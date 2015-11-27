package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import br.com.cwi.crescer.domain.Users;

@Repository
public class UsersDao {

	@PersistenceContext
	private EntityManager em;
	
	public Users findByUsername(String username){
		return em.createQuery(" FROM Users u WHERE u.username = :username",Users.class)
		.setParameter("username", username)
		.getSingleResult();
	}
	
	@Transactional
	public Users update(Users user){
		return em.merge(user);
	}
	
	@Transactional
	public void salvarNovo(Users user){
		em.persist(user);
	}
}
