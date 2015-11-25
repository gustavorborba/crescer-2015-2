package br.com.cwi.crescer.dto;

import br.com.cwi.crescer.domain.Cliente;

public class ResumoClienteDTO {
	private String nome;
	private String cpf;
	private String email;
	private Long id;
	
	public ResumoClienteDTO(Cliente cliente){
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
