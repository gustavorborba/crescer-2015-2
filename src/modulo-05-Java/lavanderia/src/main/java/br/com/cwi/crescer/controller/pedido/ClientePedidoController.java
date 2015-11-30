package br.com.cwi.crescer.controller.pedido;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.dto.TramiteDTO;
import br.com.cwi.crescer.services.ItemService;
import br.com.cwi.crescer.services.PedidoService;

@Controller
@RequestMapping("/pedido")
public class ClientePedidoController {
	private PedidoService pedidoService;
	private ItemService itemService;
	@Autowired
	public ClientePedidoController(PedidoService pedidoService, ItemService item){
		this.pedidoService = pedidoService;
		this.itemService = item;
	}
	
	@RequestMapping(path = "/pedidoindex", method = RequestMethod.GET)
	public ModelAndView cadastro() {
		return new ModelAndView("/pedido/pedidoindex");
	}
	
}
