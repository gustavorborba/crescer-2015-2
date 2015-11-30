package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Pedido;

@Repository
public class PedidoDao{
	@PersistenceContext
	private EntityManager em;
	
	public Pedido findById(long id){
		return em.find(Pedido.class, id);
	}
	
	@Transactional
	public void cadastrarPedido(Pedido pedido){
		 em.persist(pedido);
	}
	
	public List<Pedido> listarPedidos(){
		return em.createQuery("FROM Pedido p where p.cliente = :cliente" ,Pedido.class)
		.getResultList();
	}
	
	public List<Pedido> listarPedidosPorCliente(Cliente cliente){
		return em.createQuery("FROM Pedido p where p.cliente = :cliente" ,Pedido.class)
				.setParameter("cliente", cliente)
				.getResultList();
	}
}
