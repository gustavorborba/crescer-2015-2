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
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.TramiteDTO;
import br.com.cwi.crescer.services.ItemService;
import br.com.cwi.crescer.services.ProdutoService;
import br.com.cwi.crescer.services.ServicoService;

@Controller
@RequestMapping("/pedido/cadastro")
public class PedidoItemCadastroController {
	private ServicoService servicoService;
	private ProdutoService produtoService;
	private ItemService itemService;
	@Autowired
	public PedidoItemCadastroController(ServicoService servico,
			ProdutoService produto,ItemService item) {
		this.servicoService = servico;
		this.produtoService = produto;
		this.itemService = item;
	}

	@RequestMapping(path = "/clientecadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {
		return new ModelAndView("/pedido/cadastro/clienteCadastro");
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
