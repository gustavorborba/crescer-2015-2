package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Authorities;

@Repository
public class AuthoritiesDao {
	@PersistenceContext
	private EntityManager em;
	
	public List<Authorities> listAll(){
		return em.createQuery("FROM Authorities", Authorities.class)
				.getResultList();				
	}
	
	@Transactional
	public void salvarNovo(Authorities autho){
		em.persist(autho);
	}
}
