package br.com.cwi.crescer.dao;

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
		Assert.assertNotNull(cliente.getIdCidade());
	}
}
