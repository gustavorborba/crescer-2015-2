package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDao implements IDao<Cliente>{
	@PersistenceContext
	private EntityManager em;
	
	public Cliente findById(long id){
		return em.find(Cliente.class, id);
	}
	
	  public List<Cliente> findBySituacao(SituacaoCliente situacao) {
	        return em.createQuery("FROM Cliente c WHERE c.situacao = :situacao", Cliente.class)
	                .setParameter("situacao", situacao)
	                .getResultList();
	    }
}
