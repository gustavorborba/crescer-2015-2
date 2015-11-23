package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Cidade;

public class CidadeDaoTest extends AbstractInfrastructureTest{
    @Autowired
    private CidadeDao dao = new CidadeDao();
	@Test
	public void findByIdTest(){
		Cidade cidade = dao.findById(1);
		Assert.assertNotNull(cidade);
	}
}
