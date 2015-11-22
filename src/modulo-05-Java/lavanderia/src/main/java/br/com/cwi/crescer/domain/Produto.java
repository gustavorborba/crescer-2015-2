package br.com.cwi.crescer.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
@SequenceGenerator(name = Produto.SEQUENCE_NAME, sequenceName = Produto.SEQUENCE_NAME)
public class Produto {
	public static final String SEQUENCE_NAME = "SEQ_Produto";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDProduto")
	private long idProduto;
	
	@Column(name = "IDServico")
	@Basic(optional = false)
	private long idServico;
	
	@Column(name = "IDMaterial")
	@Basic(optional = false)
	private long idMaterial;
	
	@Column(name = "Valor")
	@Basic(optional = false)
	private BigDecimal valor;

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public long getIdServico() {
		return idServico;
	}

	public void setIdServico(long idServico) {
		this.idServico = idServico;
	}

	public long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
