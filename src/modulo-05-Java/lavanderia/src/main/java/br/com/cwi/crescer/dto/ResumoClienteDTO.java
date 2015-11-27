package br.com.cwi.crescer.dto;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

public class ResumoClienteDTO {
	private String nome;
	private String cpf;
	private SituacaoCliente situacao;
	private Long id;
	
	public ResumoClienteDTO(Cliente cliente){
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.situacao = cliente.getSituacao();
		this.id = cliente.getIdCliente();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SituacaoCliente getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoCliente situacao) {
		this.situacao = situacao;
	}
}
