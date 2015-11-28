package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Material;

@Repository
public class MaterialDao{
	@PersistenceContext
	private EntityManager em;
	
	public Material findById(long id){
		return em.find(Material.class, id);
	}
	
	public List<Material> listarTodosMateriais(){
		return em.createQuery("From Material",Material.class)
				.getResultList();
	}
	
}
