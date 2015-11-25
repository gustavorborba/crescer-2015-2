package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cidade;

@Repository
public class CidadeDao implements IDao<Cidade>{
	@PersistenceContext
	private EntityManager em;
	
	public Cidade findById(long id){
		return em.find(Cidade.class, id);
	}
    public List<Cidade> listAll() {
        return em.createQuery("FROM Cidade", Cidade.class)
                .getResultList();
    }
}

