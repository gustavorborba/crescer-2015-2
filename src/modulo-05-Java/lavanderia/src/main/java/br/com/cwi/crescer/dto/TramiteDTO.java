package br.com.cwi.crescer.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.mapper.ProdutoMapper;

public class TramiteDTO {
	private Long idCliente;
	private Long idServico;
	private Long idProduto;
	private Long idPedido;
	private BigDecimal peso;
	private List<ProdutoDTO> produtosVinculadosAServico;
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdServico() {
		return idServico;
	}
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}
	public Long getIdMaterial() {
		return idProduto;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public List<ProdutoDTO> getProdutosVinculadosAServico() {
		return produtosVinculadosAServico;
	}
	public void setProdutosVinculadosAServico(List<Produto> produtosVinculadosAServico) {
		this.produtosVinculadosAServico = ProdutoMapper.allToProdutoDTO(produtosVinculadosAServico);
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	
	
}
