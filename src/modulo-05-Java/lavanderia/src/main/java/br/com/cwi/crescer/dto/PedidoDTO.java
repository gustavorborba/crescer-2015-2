package br.com.cwi.crescer.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoDTO {
	private Long idPedido;
	private Date dataInclusao;
	private Date dataEntrega;
	private BigDecimal valor;
	private SituacaoPedido situacao;
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public SituacaoPedido getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}
	
}