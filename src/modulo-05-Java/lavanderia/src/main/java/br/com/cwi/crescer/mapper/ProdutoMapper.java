package br.com.cwi.crescer.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ProdutoDTO;

public class ProdutoMapper {
	public static ProdutoDTO produtoToDTO(Produto produto){
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setIdProduto(produto.getIdProduto());
		produtoDTO.setValor(produto.getValor());
		produtoDTO.setSituacao(produto.getSituacao());
		produtoDTO.setIdServico(produto.getServico().getIdServico());
		produtoDTO.setPrazo(produto.getPrazo());
		produtoDTO.setIdMaterial(produto.getMaterial().getIdMaterial());
		return produtoDTO;
	}
	
	public static Produto TOProduto(ProdutoDTO produtoDTO){
		Produto produto = new Produto();
		Material material = new Material();
		material.setIdMaterial(produtoDTO.getIdMaterial());
		Servico servico = new Servico();
		
		servico.setIdServico(produtoDTO.getIdServico());
		produto.setIdProduto(produtoDTO.getIdProduto());
		produto.setValor(produtoDTO.getValor());
		produto.setPrazo(produtoDTO.getPrazo());
		produto.setSituacao(produtoDTO.getSituacao());
		produto.setMaterial(material);
		produto.setServico(servico);
		produto.getServico().setIdServico(produtoDTO.getIdServico());
		
		return produto;
	}
	
	public static List<ProdutoDTO> allToProdutoDTO(List<Produto> produtos){
		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
		for(Produto produto : produtos){
			produtosDTO.add(ProdutoMapper.produtoToDTO(produto));
		}
		return produtosDTO;
	}
}
