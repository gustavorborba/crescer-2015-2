package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.services.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoCadastroController {
	private PedidoService pedidoService;
	
	@Autowired
	public PedidoCadastroController(PedidoService pedido){
		this.pedidoService = pedido;
	}
	
	@RequestMapping(path = "/cadastropedido/{idCliente}", method = RequestMethod.GET)
	public ModelAndView cadastrarPedido(@PathVariable("idCliente") Long idCliente,final RedirectAttributes redirectAttributes){
		Long idPedido = pedidoService.cadastrarPedido(idCliente);
		redirectAttributes.addFlashAttribute("Mensagem","Pedido Cadastrado!");
		return new ModelAndView("redirect:/pedido/cadastro/itemcadastro/" + idPedido);
	}
	
}
