package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.services.PedidoService;

@Controller
@RequestMapping("/pedido")
public class FinalizacaoPedidoController {
	private PedidoService pedidoService;
	
	@Autowired
	public FinalizacaoPedidoController(PedidoService pedido){
		this.pedidoService = pedido;
	}
	
	@RequestMapping(path = "/retirar/{idPedido}", method = RequestMethod.GET)
	public ModelAndView retirarPedido(@PathVariable("idPedido") Long idPedido){
		pedidoService.alterarSituacaoPedido(idPedido, SituacaoPedido.ENCERRADO);
		return new ModelAndView("redirect:/pedido//clientepedidos/" + idPedido);
	}
	
	@RequestMapping(path = "/cancelar/{idPedido}", method = RequestMethod.GET)
	public ModelAndView cancelarPedido(@PathVariable("idPedido") Long idPedido){
		 pedidoService.alterarSituacaoPedido(idPedido, SituacaoPedido.CANCELADO);
		 return new ModelAndView("redirect:/pedido//clientepedidos/" + idPedido);
	}
}
