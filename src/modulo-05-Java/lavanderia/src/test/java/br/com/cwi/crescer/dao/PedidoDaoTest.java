package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Pedido;

public class PedidoDaoTest extends AbstractInfrastructureTest{
	@Autowired
	private PedidoDao dao = new PedidoDao();
	
	@Test
	public void findByIdTest(){
		Pedido pedido = dao.findById(1);
		Assert.assertNotNull(pedido);
	}
	@Test
	public void joinTest(){
		Pedido pedido = dao.findById(1);
		Assert.assertNotNull(pedido.cliente());
		Assert.assertNotNull(pedido.getItens());
		
	}
}
