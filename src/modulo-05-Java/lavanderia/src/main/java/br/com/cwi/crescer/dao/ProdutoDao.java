package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDao implements IDao<Produto>{
	@PersistenceContext
	private EntityManager em;
	
	public Produto findById(long id){
		return em.find(Produto.class, id);
	}
	
	public List<Pedido> listarProdutos(){
		return em.createQuery("FROM Produto",Pedido.class)
				.getResultList();
	}
	
	@Transactional
	public Produto salvarAlteracao(Produto produto){
		if(produto.idIsNull()){
			em.persist(produto);
			return produto;
		}
		return em.merge(produto);
	}
}
