package br.com.cwi.crescer.controller.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.services.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoEditarController {
	private ProdutoService produtoService;
	
	@Autowired
	public ProdutoEditarController(ProdutoService produtoService){
		this.produtoService = produtoService;
	}
	
	@RequestMapping(path = "/editar/{id}",method = RequestMethod.GET)
	public ModelAndView listarProdutos(@PathVariable("id") Long id){
		return new ModelAndView("Produto/editar", "produtos",produtoService.buscarProduto(id));
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.POST)
	public ModelAndView salvarEdicao(ProdutoDTO dto, final RedirectAttributes redirectAttributes) {
		produtoService.salvarEdicao(dto);
		redirectAttributes.addFlashAttribute("Mensagem", "Cliente editado com sucesso!");
		return new ModelAndView("redirect:/produto");
	}
}
