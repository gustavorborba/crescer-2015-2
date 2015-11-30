package br.com.cwi.crescer.controller.pedido;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.TramiteDTO;
import br.com.cwi.crescer.services.ClienteService;
import br.com.cwi.crescer.services.ItemService;
import br.com.cwi.crescer.services.PedidoService;
import br.com.cwi.crescer.services.ProdutoService;
import br.com.cwi.crescer.services.ServicoService;

@Controller
@RequestMapping("/pedido/cadastro")
public class PedidoCadastroController {
	private ClienteService clienteService;
	private ServicoService servicoService;
	private ProdutoService produtoService;
	private PedidoService pedidoService;
	private ItemService itemService;
	@Autowired
	public PedidoCadastroController(ClienteService clienteService, ServicoService servico,
			ProdutoService produto, PedidoService pedidoService,ItemService item) {
		this.clienteService = clienteService;
		this.servicoService = servico;
		this.produtoService = produto;
		this.pedidoService = pedidoService;
		this.itemService = item;
	}

	@RequestMapping(path = "/clientecadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {
		return new ModelAndView("/pedido/cadastro/clienteCadastro");
	}

	@RequestMapping(path = "/clientecadastro", method = RequestMethod.POST)
	public ModelAndView validarCliente(String cpf, final RedirectAttributes redirectAttributes) {
		ClienteDTO dto = clienteService.buscarPorCpf(cpf);
		boolean clienteNaoEncontrado = dto == null;
		if (clienteNaoEncontrado) {
			redirectAttributes.addFlashAttribute("Mensagem", "Cliente não encontrado, tente novamente");
			return new ModelAndView("redirect:/pedido/cadastro/clientecadastro");
		}
		return new ModelAndView("/pedido/pedidos", "pedidos", pedidoService.criarDTOQueContemListaDePedidos(dto));
	}
	
	@RequestMapping(path = "/itemcadastro/{idPedido}/{idProduto}/{peso}", method = RequestMethod.GET)
	public ModelAndView cadastroItem(@PathVariable("idPedido") Long idPedido,@PathVariable("idProduto") Long idProduto,
			@PathVariable("peso") BigDecimal peso) {
		Long id = itemService.cadastrarItem(idProduto, idPedido, peso).getPedido().getIdPedido();
		TramiteDTO tramite = new TramiteDTO();
		tramite.setIdPedido(id);
		return new ModelAndView("/pedido/cadastro/servicocadastro","pedidos", tramite);
	}
	
	@RequestMapping(path = "/itemcadastro/{idPedido}", method = RequestMethod.GET)
	public ModelAndView telaCadastroItem(@PathVariable("idPedido") Long idPedido) {
		TramiteDTO tramiteDTO = new TramiteDTO();
		tramiteDTO.setIdPedido((long)idPedido);
		return new ModelAndView("/pedido/cadastro/servicocadastro","pedidos" , tramiteDTO);
	}
	
	@RequestMapping(path = "/servicocadastro", method = RequestMethod.POST)
	public ModelAndView servicosPedido(TramiteDTO dto){
		dto.setProdutosVinculadosAServico(produtoService.buscarCombinacao(dto.getIdServico(), null));
		return new ModelAndView("/pedido/cadastro/servicocadastro", "pedidos", dto);
	}

	@ModelAttribute("servicos")
	public List<Servico> comboServico() {
		return servicoService.listarTodosServicos();
	}
}
