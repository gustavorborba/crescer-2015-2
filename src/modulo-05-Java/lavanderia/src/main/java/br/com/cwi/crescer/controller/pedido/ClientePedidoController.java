package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.PedidoClienteDTO;
import br.com.cwi.crescer.services.ClienteService;
import br.com.cwi.crescer.services.PedidoService;

@Controller
@RequestMapping("/pedido")
public class ClientePedidoController {
	private PedidoService pedidoService;
	private ClienteService clienteService;
	@Autowired
	public ClientePedidoController(PedidoService pedidoService, ClienteService cliente){
		this.pedidoService = pedidoService;
		this.clienteService = cliente;
	}
	
	@RequestMapping(path = "/pedidoindex", method = RequestMethod.GET)
	public ModelAndView cadastro() {
		return new ModelAndView("/pedido/pedidoindex");
	}
	
	@RequestMapping(path = "/clientepedidos", method = RequestMethod.POST)
	public ModelAndView validarCliente(String cpf, final RedirectAttributes redirectAttributes) {
		PedidoClienteDTO pedidos = pedidoService.criarDTOQueContemListaDePedidos(clienteService.buscarPorCpf(cpf));
		boolean clienteNaoEncontrado = pedidos.getIdCliente() == null;
		if (clienteNaoEncontrado) {
			redirectAttributes.addFlashAttribute("Mensagem", "Cliente não encontrado, tente novamente");
			return new ModelAndView("redirect:/pedido/cadastro/clientecadastro");
		}
		return new ModelAndView("/pedido/pedidos", "pedidos", pedidos);
	}
	
	
	@RequestMapping(path = "/clientepedidos/processando/{idPedido}", method = RequestMethod.GET)
	public ModelAndView processarPedido(@PathVariable("idPedido") Long idPedido){
		Cliente cliente = pedidoService.alterarSituacaoPedido(idPedido,SituacaoPedido.PROCESSANDO).cliente();
		return new ModelAndView("/pedido/pedidos", "pedidos", pedidoService.criarDTOQueContemListaDePedidos(cliente));
	}
}
