package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDao {
	@PersistenceContext
	private EntityManager em;
	
	public Produto findById(long id){
		return em.find(Produto.class, id);
	}
}
