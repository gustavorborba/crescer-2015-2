package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.services.ItemService;
import br.com.cwi.crescer.services.PedidoService;

@Controller
@RequestMapping("/pedido")
public class ItemPedidoController {
	private PedidoService pedidoService;
	private ItemService itemService;
	@Autowired
	public ItemPedidoController(PedidoService pedidoService, ItemService item){
		this.pedidoService = pedidoService;
		this.itemService = item;
	}	
	@RequestMapping(path = "/itens/{idPedido}", method = RequestMethod.GET)
	public ModelAndView listaItens(@PathVariable("idPedido") Long idPedido){
		return new ModelAndView("/pedido/itens", "itens", pedidoService.listarItensVinculadosAPedido(idPedido));
	}
	@RequestMapping(path = "/itens/processar/{idItem}", method = RequestMethod.GET)
	public ModelAndView processarItem(@PathVariable("idItem") Long idItem,final RedirectAttributes redirectAttributes){
		Long id = itemService.processarItem(idItem).getPedido().getIdPedido();
		redirectAttributes.addFlashAttribute("Mensagem","Processado com Sucesso!");
		return new ModelAndView("redirect:/pedido/itens/" + id);
	}
}
