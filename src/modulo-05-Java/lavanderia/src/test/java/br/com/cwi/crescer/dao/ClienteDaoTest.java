package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Cliente;

public class ClienteDaoTest extends AbstractInfrastructureTest{
	@Autowired
	private ClienteDao dao = new ClienteDao();
    @Test
	public void findByIdTest(){
		Cliente cliente = dao.findById(1);
		Assert.assertNotNull(cliente);
	}
    @Test
    public void joinTest(){
    	Cliente cliente = dao.findById(1);
    	Assert.assertNotNull(cliente.getEndereco());
		Assert.assertNotNull(cliente.getPedidos());
		Assert.assertNotNull(cliente.getEndereco());		
    }
    @Test
    public void bucarNomeTest(){
    	List<Cliente> cliente = dao.findByName("Car");
    	Assert.assertEquals(3, cliente.size());
    }
}
