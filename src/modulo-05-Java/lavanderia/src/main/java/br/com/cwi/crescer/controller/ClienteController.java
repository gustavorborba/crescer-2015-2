package br.com.cwi.crescer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.services.CidadeService;
import br.com.cwi.crescer.services.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	private ClienteService clienteService;
    private CidadeService cidadeService;

    @Autowired
    public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
        this.clienteService = clienteService;
        this.cidadeService = cidadeService; 
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar(){
    	return new ModelAndView("Cliente/lista", "clientes", clienteService.listarClientesAtivos());
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("Cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
    }
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/editar", "cliente", clienteService.buscarClientePorId(id));
    }
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView salvarEdicao(ClienteDTO dto) {
        clienteService.atualizarCliente(dto);
        return new ModelAndView("redirect:/cliente");
    }
    @RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
    public ModelAndView viewRemover(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/ExclusaoDeCliente", "cliente", clienteService.buscarClientePorId(id));
    }
    @RequestMapping(path = "/remover", method = RequestMethod.POST)
    public ModelAndView salvarExclusaoDeCliente(ClienteDTO dto) {
        clienteService.removerCliente(dto.getId());
        return new ModelAndView("redirect:/cliente");
    }
    @RequestMapping(path = "/cadastrar", method = RequestMethod.GET)
    public ModelAndView viewCadastrarCliente(ClienteDTO dto) {
        return new ModelAndView("cliente/cadastrar", "cliente", dto);
    }
    @RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView salvarCadastroCliente(ClienteDTO dto) {
        clienteService.cadastrarCliente(dto);
        return new ModelAndView("redirect:/cliente");
    }
    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
}
