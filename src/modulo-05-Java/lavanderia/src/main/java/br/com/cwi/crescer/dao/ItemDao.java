package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Item;

@Repository
public class ItemDao{
	@PersistenceContext
	private EntityManager em;
	
	public Item findById(long id){
		return em.find(Item.class, id);
	}
	
	@Transactional
	public Item salvarAlteracoes(Item item){
		if(item.getIdItem() == null){
			em.persist(item);
			return item;
		}
		return em.merge(item);
	}
}
