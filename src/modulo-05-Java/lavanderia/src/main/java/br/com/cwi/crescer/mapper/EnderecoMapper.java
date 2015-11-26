package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.domain.Endereco;
import br.com.cwi.crescer.dto.ClienteDTO;

public class EnderecoMapper {
	public static Endereco dtoToEndendereco(ClienteDTO clienteDTO){
		Cidade cidade = new Cidade();
		cidade.setIdCidade(clienteDTO.getIdCidade());
		cidade.setUf(clienteDTO.getUf());
		
		Endereco endereco = new Endereco();
		endereco.setBairro(clienteDTO.getBairro());
		endereco.setCep(clienteDTO.getCep());
		endereco.setCidade(cidade);
		endereco.setEndereco(clienteDTO.getEndereco());
		return endereco;
	}
}
