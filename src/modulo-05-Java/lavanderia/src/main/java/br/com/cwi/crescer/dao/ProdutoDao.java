package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDao{
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
	
	public Produto buscarCombinacao(Produto produto){
		StringBuilder query = new StringBuilder();
		query.append("FROM Produto p where p.servico = :idServico and p.material = :idMaterial");
		return em.createQuery(query.toString(),Produto.class)
			.setParameter("idServico", produto.getServico())
			.setParameter("idMaterial", produto.getMaterial())
			.getSingleResult();
				
	}
}
