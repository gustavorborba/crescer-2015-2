package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Produto.ProdutoSituacao;

public class ProdutoDTO {
	private Long idProduto;
	private BigDecimal valor;
	private ProdutoSituacao situacao;
	private int prazo;
	private Long idServico;
	private Long idMaterial;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	
	public ProdutoSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(ProdutoSituacao situacao) {
		this.situacao = situacao;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
}
