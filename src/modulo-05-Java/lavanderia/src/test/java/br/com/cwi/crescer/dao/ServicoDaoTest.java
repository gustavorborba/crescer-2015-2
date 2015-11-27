package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.domain.Servico.ServicoDescricao;

public class ServicoDaoTest extends AbstractInfrastructureTest{
	@Autowired
	ServicoDao dao = new ServicoDao();
	
	@Test
	public void findById(){
		Servico servico = dao.findById(21);
		Assert.assertEquals(ServicoDescricao.Lavar, servico.getDescricao());
	}
}
