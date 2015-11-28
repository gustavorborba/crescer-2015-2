package br.com.cwi.crescer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ProdutoDao;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.mapper.ProdutoMapper;

@Service
public class ProdutoService {
	
	private ProdutoDao produtoDao = new ProdutoDao();
	
	@Autowired
	public ProdutoService(ProdutoDao dao){
		this.produtoDao = dao;
	}
	
	public ProdutoDTO buscarProduto(Long id){
		return ProdutoMapper.produtoToDTO(produtoDao.findById(id));
	}
	
	public Boolean combinacaoValida(Long idServico, Long idMaterial){
		return !this.buscarCombinacao(idServico, idMaterial).isEmpty();
	}
	
	private List<Produto> buscarCombinacao(Long idServico, Long idMaterial){
		Servico servico = new Servico();
		Material material = new Material();
		servico.setIdServico(idServico);
		material.setIdMaterial(idMaterial);
		return produtoDao.buscarCombinacao(servico,material);
	}

	public void salvarCadastro(ProdutoDTO produtoDTO){
		Produto produto = ProdutoMapper.TOProduto(produtoDTO);
		produto.ativarProduto();
		produtoDao.salvarAlteracao(produto);
	}
	
	public void salvarEdicao(ProdutoDTO produtoDTO){
		Produto produto = ProdutoMapper.TOProduto(produtoDTO);
		produtoDao.salvarAlteracao(produto);
	}
	
	public List<ProdutoDTO> listarProdutos(){
		List<Produto> produto = produtoDao.listarProdutos();
		return ProdutoMapper.allToProdutoDTO(produto);
	}
}
