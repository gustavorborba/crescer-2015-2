package br.com.cwi.crescer.controller.cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;
import br.com.cwi.crescer.services.CidadeService;
import br.com.cwi.crescer.services.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteEdicaoController {

	private ClienteService clienteService;
	private CidadeService cidadeService;

	@Autowired
	public ClienteEdicaoController(ClienteService clienteService, CidadeService cidadeService) {
		this.clienteService = clienteService;
		this.cidadeService = cidadeService;
	}
	
	@RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView viewEdita(@PathVariable("id") Long id) {
		return new ModelAndView("cliente/editar", "cliente", ClienteMapper.clienteToClienteDTO(clienteService.buscarClientePorId(id)));
	}

	@RequestMapping(path = "/editar", method = RequestMethod.POST)
	public ModelAndView salvarEdicao(ClienteDTO dto, final RedirectAttributes redirectAttributes) {
		clienteService.atualizarCliente(dto);
		redirectAttributes.addFlashAttribute("Mensagem", "Cliente editado com sucesso!");
		return new ModelAndView("redirect:/cliente");
	}

	@RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
	public ModelAndView viewRemover(@PathVariable("id") Long id) {
		return new ModelAndView("cliente/ExclusaoDeCliente", "cliente", ClienteMapper.clienteToClienteDTO(clienteService.buscarClientePorId(id)));
	}

	@RequestMapping(path = "/remover", method = RequestMethod.POST)
	public ModelAndView salvarExclusaoDeCliente(ClienteDTO dto, final RedirectAttributes redirectAttributes) {
		clienteService.removerCliente(dto.getId());
		redirectAttributes.addFlashAttribute("Mensagem", "Cliente removido com sucesso!");
		return new ModelAndView("redirect:/cliente");
	}

	@RequestMapping(path = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView viewCadastrarCliente(ClienteDTO dto) {
		return new ModelAndView("cliente/cadastrar", "cliente", dto);
	}

	@RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView salvarCadastroCliente(@Valid @ModelAttribute("cliente") ClienteDTO clienteDTO,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
		    return new ModelAndView("cliente/cadastrar");
		}
			clienteService.cadastrarCliente(clienteDTO);
		redirectAttributes.addFlashAttribute("Mensagem", "Cliente cadastrado com sucesso");
		return new ModelAndView("redirect:/cliente");
	}
	
	@ModelAttribute("cidades")
	public List<Cidade> comboCidades() {
		return cidadeService.listar();
	}
}
