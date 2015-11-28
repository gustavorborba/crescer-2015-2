package br.com.cwi.crescer.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
@SequenceGenerator(name = Produto.SEQUENCE_NAME, sequenceName = Produto.SEQUENCE_NAME,initialValue = 50, allocationSize = 1)
public class Produto {
	public static final String SEQUENCE_NAME = "SEQ_Produto";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDProduto")
	private Long idProduto;
	
	@ManyToOne
	@JoinColumn(name = "IDServico")
	@Basic(optional = false)
	private Servico servico;
	
	@ManyToOne
	@JoinColumn(name = "IDMaterial")
	@Basic(optional = false)
	private Material material;
	
	@Column(name = "Valor")
	@Basic(optional = false)
	private BigDecimal valor;

	@Column(name = "Situacao")
	@Enumerated(EnumType.ORDINAL)
	@Basic(optional = false)
	private ProdutoSituacao situacao;
	
	@Column(name = "Prazo",length = 3)
	private int prazo;
	public static enum ProdutoSituacao{
		Ativo,Inativo
	}
	
	public boolean idIsNull(){
    	return this.idProduto == null;
    }
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
