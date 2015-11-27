package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDao {
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
	    
	    @Transactional
	    public Cliente save(Cliente cliente) {
	        if (cliente.getIdCliente() == null) {
	            em.persist(cliente);
	            return cliente;
	        }
	        return em.merge(cliente);
	    }
	    public List<Cliente> findByName(String nome){
	    	return em.createQuery("FROM Cliente as c where c.nome like :nome",Cliente.class)
	    	.setParameter("nome", nome +"%")
	    	.getResultList();
	    }
}
