package br.com.cwi.crescer.controller.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.services.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoListarController {
	private ProdutoService produtoService;
	
	@Autowired
	public ProdutoListarController(ProdutoService produtoService){
		this.produtoService = produtoService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listarProdutos(){
		return new ModelAndView("Produto/listar", "produtos",produtoService.listarProdutos());
	}
}
