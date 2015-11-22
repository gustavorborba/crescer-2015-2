package br.com.cwi.crescer.dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.cwi.crescer.LavanderiaApplication;
import br.com.cwi.crescer.domain.Cidade;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LavanderiaApplication.class)
@WebAppConfiguration
public class CidadeDaoTest {
    @Resource
    private CidadeDao dao = new CidadeDao();
	@Test
	public void findByIdTest(){
		Cidade cidade = dao.findById(1);
		Assert.assertEquals("RS", cidade.getUf());
	}
}
