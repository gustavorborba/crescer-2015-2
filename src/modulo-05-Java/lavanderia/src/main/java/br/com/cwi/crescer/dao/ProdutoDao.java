package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Servico;

@Repository
public class ProdutoDao{
	@PersistenceContext
	private EntityManager em;
	
	public Produto findById(long id){
		return em.find(Produto.class, id);
	}
	
	public List<Produto> listarProdutos(){
		return em.createQuery("FROM Produto",Produto.class)
				.getResultList();
	}
	
	@Transactional
	public Produto salvarAlteracao(Produto produto){
		if(produto.idIsNull()){
			em.persist(produto);
			return produto;
		}
		return em.merge(produto);
	}

	public List<Produto> buscarCombinacao(Servico servico, Material material){
		StringBuilder query = new StringBuilder();
		query.append("FROM Produto p where p.servico = :idServico and p.material = :idMaterial");
		return em.createQuery(query.toString(),Produto.class)
			.setParameter("idServico", servico)
			.setParameter("idMaterial", material)
			.getResultList();
			
	}
}
