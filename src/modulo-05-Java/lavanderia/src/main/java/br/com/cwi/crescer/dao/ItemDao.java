package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Item;

@Repository
public class ItemDao implements IDao<Item> {
	@PersistenceContext
	private EntityManager em;
	
	public Item findById(long id){
		return em.find(Item.class, id);
	}
}
