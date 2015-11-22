package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;

@Repository
public class ClienteDao {
	@PersistenceContext
	private EntityManager em;
	
	public Cliente findById(long id){
		return em.find(Cliente.class, id);
	}
}
