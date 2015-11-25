package br.com.cwi.crescer.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.ResumoClienteDTO;

public class ClienteMapper {
	public static Cliente dtoToCliente(ClienteDTO clienteDTO){		
		Cliente cliente = new Cliente();
		
		cliente.setNome(clienteDTO.getNome());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setEndereco(EnderecoMapper.dtoToEndendereco(clienteDTO));	
		return cliente;
	}
	public static ClienteDTO clienteToClienteDTO(Cliente cliente){
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setBairro(cliente.getEndereco().getBairro());
		clienteDTO.setCep(cliente.getEndereco().getCep());
		clienteDTO.setEndereco(cliente.getEndereco().getEndereco());
		clienteDTO.setIdCidade(cliente.getEndereco().getCidade().getIdCidade());
		clienteDTO.setNomeCidade(cliente.getEndereco().getCidade().getNome());
		clienteDTO.setUf(cliente.getEndereco().getCidade().getUf());
		
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setId(cliente.getIdCliente());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setEmail(cliente.getEmail());
		return clienteDTO;
	}
	public static Cliente merge(Cliente cliente, ClienteDTO clienteDTO){
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNome(clienteDTO.getNome());
		cliente.setEndereco(EnderecoMapper.dtoToEndendereco(clienteDTO));
		
		return cliente;
	}
	public static List<ResumoClienteDTO> allToResumoClienteDTO(List<Cliente> clientes){
		ArrayList<ResumoClienteDTO> clientesDTO = new ArrayList<ResumoClienteDTO>();
		for (Cliente cliente : clientes) {
			clientesDTO.add(new ResumoClienteDTO(cliente));
		}
		return clientesDTO;
	}
}
