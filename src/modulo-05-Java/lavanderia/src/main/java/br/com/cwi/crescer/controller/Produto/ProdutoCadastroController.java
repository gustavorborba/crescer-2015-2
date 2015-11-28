package br.com.cwi.crescer.controller.Produto;

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
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.services.MaterialService;
import br.com.cwi.crescer.services.ProdutoService;
import br.com.cwi.crescer.services.ServicoService;

@Controller
@RequestMapping("/produto")
public class ProdutoCadastroController {
	private ProdutoService produtoService;
	private MaterialService materialService;
	private ServicoService servicoService;

	@Autowired
	public ProdutoCadastroController(ProdutoService produto, MaterialService materialService,
		ServicoService servicoService) {
		this.produtoService = produto;
		this.materialService = materialService;
		this.servicoService = servicoService;
	}

	@RequestMapping(path = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrar(ProdutoDTO dto) {
		return new ModelAndView("produto/cadastrar", "produto", dto);
	}

	@RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView salvarCadastro(ProdutoDTO dto, final RedirectAttributes redirectAttributes) {
		boolean materialEServicoValidos = produtoService.combinacaoValida(dto.getIdServico(), dto.getIdMaterial());
		if (materialEServicoValidos) {
			redirectAttributes.addFlashAttribute("Mensagem",
					"Combinacao Servico/Material já se encontra na base de dados");
			return new ModelAndView("redirect:/produto/cadastrar");
		}
		produtoService.salvarCadastro(dto);
		redirectAttributes.addFlashAttribute("Mensagem", "Produto cadastrado com Sucesso!");
		return new ModelAndView("redirect:/produto");
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
