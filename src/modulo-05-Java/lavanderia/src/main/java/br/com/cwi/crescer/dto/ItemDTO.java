package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Item.SituacaoItem;

public class ItemDTO {
	private Long idItem;
	private Long idPedido;
	private Long idProduto;
	private BigDecimal peso;
	private BigDecimal valorUnitario;
	private BigDecimal valorDesconto;
	private BigDecimal valorToral;
	private SituacaoItem situacao;
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public BigDecimal getValorToral() {
		return valorToral;
	}
	public void setValorToral(BigDecimal valorToral) {
		this.valorToral = valorToral;
	}
	public SituacaoItem getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoItem situacao) {
		this.situacao = situacao;
	}
	
	
}
