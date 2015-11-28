package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import br.com.cwi.crescer.domain.Material.MaterialDescricao;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Servico.ServicoDescricao;

public class ProdutoDTO {
	private Long idProduto;
	private BigDecimal valor;
	private Long idServico;
	private ServicoDescricao servicoDescricao;
	private Long idMaterial;
	private MaterialDescricao materialDescricao;
	
	public ProdutoDTO(Produto produto){
		this.idProduto = produto.getIdProduto();
		this.valor = produto.getValor();
		this.idServico = produto.getServico().getIdServico();
		this.servicoDescricao = produto.getServico().getDescricao();
		this.idMaterial = produto.getMaterial().getIdMaterial();
		this.materialDescricao = produto.getMaterial().getDescricao();
	}

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

	public ServicoDescricao getServicoDescricao() {
		return servicoDescricao;
	}

	public void setServicoDescricao(ServicoDescricao servicoDescricao) {
		this.servicoDescricao = servicoDescricao;
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public MaterialDescricao getMaterialDescricao() {
		return materialDescricao;
	}

	public void setMaterialDescricao(MaterialDescricao materialDescricao) {
		this.materialDescricao = materialDescricao;
	}
	
	
}
