package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ProdutoDTO;

public class ProdutoMapper {
	public static ProdutoDTO produtoToDTO(Produto produto){
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setIdProduto(produto.getIdProduto());
		produtoDTO.setValor(produto.getValor());
		produtoDTO.setSituacao(produto.getSituacao());
		produtoDTO.setIdServico(produto.getServico().getIdServico());
		produtoDTO.setPrazo(produto.getPrazo());
		produtoDTO.setServicoDescricao(produto.getServico().getDescricao());
		produtoDTO.setIdMaterial(produto.getMaterial().getIdMaterial());
		produtoDTO.setMaterialDescricao(produto.getMaterial().getDescricao());
		return produtoDTO;
	}
	
	public static Produto TOProduto(ProdutoDTO produtoDTO){
		Produto produto = new Produto();
		produto.setIdProduto(produtoDTO.getIdProduto());
		produto.setValor(produtoDTO.getValor());
		produto.setPrazo(produtoDTO.getPrazo());
		produto.setSituacao(produtoDTO.getSituacao());
		produto.getMaterial().setDescricao(produtoDTO.getMaterialDescricao());
		produto.getMaterial().setIdMaterial(produtoDTO.getIdMaterial());
		produto.getServico().setDescricao(produtoDTO.getServicoDescricao());
		produto.getServico().setIdServico(produtoDTO.getIdServico());
		return produto;
	}
}
