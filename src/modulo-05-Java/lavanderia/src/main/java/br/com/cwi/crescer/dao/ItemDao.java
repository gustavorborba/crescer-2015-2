package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Pedido;

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
	public List<Item> verificarItemASerProcessado(Pedido pedido){
		return em.createQuery("From Item i where i.pedido = :pedido and i.situacao = :situacao",Item.class)
				.setParameter("pedido", pedido)
				.setParameter("situacao", SituacaoItem.PROCESSADO)
				.getResultList();
	}
}
