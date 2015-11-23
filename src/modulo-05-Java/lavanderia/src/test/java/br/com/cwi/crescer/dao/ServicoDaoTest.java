package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Servico;

public class ServicoDaoTest extends AbstractInfrastructureTest{
	@Autowired
	ServicoDao dao = new ServicoDao();
	
	@Test
	public void findById(){
		Servico servico = dao.findById(1);
		Assert.assertNotNull(servico);
	}
}
