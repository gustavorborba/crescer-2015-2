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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
@SequenceGenerator(name = Item.SEQUENCE_NAME, sequenceName = Item.SEQUENCE_NAME)
public class Item {
	public static final String SEQUENCE_NAME = "SEQ_Item";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDItem")
	private long idItem;
	
	@Column(name = "IDPedido")
	@Basic(optional = false)
	private long idPedido;
	
	@Column(name = "IDProduto")
	@Basic(optional = false)
	private long idProduto;
	
	@Column(name = "Peso")
	@Basic(optional = false)
	private BigDecimal peso;
	
	@Column(name = "VALORUnitario")
	@Basic(optional = false)
	private BigDecimal valorUnitario;
	
	@Column(name = "VALORDesconto")
	@Basic(optional = false)
	private BigDecimal valorDesconto;
	
	@Column(name = "VALORTotal")
	@Basic(optional = false)
	private BigDecimal valorTotal;
	
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Situacao", length = 1)
    private SituacaoItem situacao;

    public static enum SituacaoItem {
        PENDENTE, PROCESSANDO, PROCESSADO
    }

	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public SituacaoItem getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoItem situacao) {
		this.situacao = situacao;
	}
	
}