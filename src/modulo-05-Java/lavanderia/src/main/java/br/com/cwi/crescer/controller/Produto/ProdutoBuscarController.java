package br.com.cwi.crescer.controller.Produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.IdsDTO;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.mapper.ProdutoMapper;
import br.com.cwi.crescer.services.MaterialService;
import br.com.cwi.crescer.services.ProdutoService;
import br.com.cwi.crescer.services.ServicoService;

@Controller
@RequestMapping("/produto/buscar")
public class ProdutoBuscarController {
	private ProdutoService produtoService;
	private MaterialService materialService;
	private ServicoService servicoService;

	@Autowired
	public ProdutoBuscarController(ProdutoService produto, MaterialService materialService,
			ServicoService servicoService) {
		this.produtoService = produto;
		this.materialService = materialService;
		this.servicoService = servicoService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView procurarProduto() {
		IdsDTO ids = new IdsDTO();
		return new ModelAndView("produto/buscar", "produto", ids);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView realizarProcura(IdsDTO ids) {
		List<ProdutoDTO> produtosDTO = ProdutoMapper.allToProdutoDTO(produtoService.buscarCombinacao(ids.getIdServico(),
														ids.getIdMaterial()));
		return new ModelAndView("produto/listar", "produtos", produtosDTO);
	}

	@ModelAttribute("materiais")
	public List<Material> comboMaterial() {
		return this.materialService.listarTodosMateriais();
	}

	@ModelAttribute("servicos")
	public List<Servico> comboServico() {
		return this.servicoService.listarTodosServicos();
	}
}
