package br.com.cwi.crescer.dto;

import java.util.List;

public class PedidoClienteDTO {
	private Long idCliente;
	private String nomeCliente;
	private String cpf;
	private List<PedidoDTO> pedidosVInculados;
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public List<PedidoDTO> getPedidosVInculados() {
		return pedidosVInculados;
	}
	public void setPedidosVInculados(List<PedidoDTO> pedidosVInculados) {
		this.pedidosVInculados = pedidosVInculados;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
