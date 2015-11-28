package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Servico;

@Repository
public class ServicoDao implements IDao<Servico>{
	@PersistenceContext
	private EntityManager em;
	
	public Servico findById(long id){
		return em.find(Servico.class, id);
	}
	public List<Servico> listarTodosServicos(){
		return em.createQuery("From Servico",Servico.class)
				.getResultList();
	}
}
