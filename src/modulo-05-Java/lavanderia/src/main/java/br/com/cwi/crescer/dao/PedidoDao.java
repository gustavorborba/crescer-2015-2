package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pedido;

@Repository
public class PedidoDao {
	@PersistenceContext
	private EntityManager em;
	
	public Pedido findById(long id){
		return em.find(Pedido.class, id);
	}
}
