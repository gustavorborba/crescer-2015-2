package br.com.cwi.crescer.controller.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.TramiteDTO;
import br.com.cwi.crescer.services.ClienteService;
import br.com.cwi.crescer.services.MaterialService;
import br.com.cwi.crescer.services.ServicoService;

@Controller
@RequestMapping("/pedido/cadastro")
public class PedidoCadastroController {
	private ClienteService clienteService;
	private ServicoService servicoService;
	private MaterialService materialService;

	@Autowired
	public PedidoCadastroController(ClienteService clienteService, ServicoService servico,
			MaterialService material) {
		this.clienteService = clienteService;
		this.servicoService = servico;
		this.materialService = material;
	}

	@RequestMapping(path = "/clientecadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {
		return new ModelAndView("/pedido/cadastro/clienteCadastro");
	}

	@RequestMapping(path = "/clientecadastro", method = RequestMethod.POST)
	public ModelAndView cadastrarCliente(String nomeCliente, final RedirectAttributes redirectAttributes) {
		ClienteDTO dto = clienteService.buscarPorNome(nomeCliente);
		boolean clienteNaoEncontrado = dto == null;
		if (clienteNaoEncontrado) {
			redirectAttributes.addFlashAttribute("Mensagem", "Cliente não encontrado, tente novamente");
			return new ModelAndView("redirect:/pedido/cadastro/clientecadastro");
		}
		TramiteDTO tramiteDTO = new TramiteDTO();
		tramiteDTO.setIdCliente(tramiteDTO.getIdCliente());
		return new ModelAndView("/pedido/cadastro/servicocadastro", "pedidos", tramiteDTO);
	}
	@RequestMapping(path = "/servicocadastro",method = RequestMethod.POST)
	public ModelAndView servicoCadastro(TramiteDTO dto){
		return new ModelAndView("redirect:/cliente");
	}
	@ModelAttribute("materiais")
	public List<Material> comboMaterial() {
		return materialService.listarTodosMateriais();
	}

	@ModelAttribute("servicos")
	public List<Servico> comboServico() {
		return servicoService.listarTodosServicos();
	}
}
