package br.com.cwi.crescer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.dto.ResumoClienteDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ClienteService {

    private ClienteDao clienteDAO;

    @Autowired
    public ClienteService(ClienteDao clientedao){
        this.clienteDAO = clientedao;
    }
	public ClienteDTO buscarClientePorId(Long id){
		Cliente cliente = this.clienteDAO.findById(id);
		return ClienteMapper.clienteToClienteDTO(cliente);
	}
	
	public List<ResumoClienteDTO> listarClientesAtivos(){
		List<Cliente> clientes = this.clienteDAO.findBySituacao(SituacaoCliente.ATIVO);
		return ClienteMapper.allToResumoClienteDTO(clientes);
	}
	public void atualizarCliente(ClienteDTO clienteDTO){
		Cliente cliente = clienteDAO.findById(clienteDTO.getId()) ;
		ClienteMapper.merge(cliente, clienteDTO);
		this.clienteDAO.save(cliente);
	}
	public void cadastrarCliente(ClienteDTO clienteDTO){
		Cliente cliente = ClienteMapper.dtoToCliente(clienteDTO);
		cliente.ativarCliente();
		clienteDAO.save(cliente);
	}
	public void removerCliente(long id){
		Cliente cliente = clienteDAO.findById(id);
		cliente.desativarCliente();
		clienteDAO.save(cliente);
	}
	
	public ClienteDTO buscarPorNome(String nome){
		List<Cliente> clientes = clienteDAO.buscarPorNome(nome);
		boolean clienteEncontrado = clientes.isEmpty();
		if(clienteEncontrado){
			return null;
		}
		return ClienteMapper.clienteToClienteDTO(clientes.get(0)) ;
		
	}
	
	public List<ResumoClienteDTO> buscarPorNomeParcial(String nome){
		List<Cliente> cliente = clienteDAO.findByNameParcial(nome);
		return ClienteMapper.allToResumoClienteDTO(cliente);
	}
}
