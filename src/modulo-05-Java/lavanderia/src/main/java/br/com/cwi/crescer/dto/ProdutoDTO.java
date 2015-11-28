package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Produto.ProdutoSituacao;

public class ProdutoDTO {
	private Long idProduto;
	private BigDecimal valor;
	private ProdutoSituacao situacao;
	private int prazo;
	private Long idServico;
	private String servicoDescricao;
	private Long idMaterial;
	private String materialDescricao;

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

	public String getServicoDescricao() {
		return servicoDescricao;
	}

	public void setServicoDescricao(String descricao) {
		this.servicoDescricao = descricao;
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getMaterialDescricao() {
		return materialDescricao;
	}

	public void setMaterialDescricao(String materialDescricao) {
		this.materialDescricao = materialDescricao;
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
