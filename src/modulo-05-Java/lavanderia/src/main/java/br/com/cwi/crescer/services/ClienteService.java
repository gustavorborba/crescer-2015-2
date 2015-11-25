package br.com.cwi.crescer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.ResumoClienteDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ClienteService {
	private ClienteDao clienteDAO;
	
	@Autowired
	public ClienteService(ClienteDao dao){
		this.clienteDAO = dao;
	}
	
	public ClienteDTO buscarClientePorId(Long id){
		Cliente cliente = clienteDAO.findById(id);
		return ClienteMapper.clienteToClienteDTO(cliente);
	}
	
	public List<ResumoClienteDTO> listarClientesAtivos(){
		List<Cliente> clientes = clienteDAO.findBySituacao(SituacaoCliente.ATIVO);
		return ClienteMapper.allToResumoClienteDTO(clientes);
	}
}
