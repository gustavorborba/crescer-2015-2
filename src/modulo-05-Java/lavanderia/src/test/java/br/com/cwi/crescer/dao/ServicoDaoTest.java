package br.com.cwi.crescer.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.cwi.crescer.LavanderiaApplication;
import br.com.cwi.crescer.domain.Servico;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LavanderiaApplication.class)
@WebAppConfiguration
public class ServicoDaoTest {
	@Resource
	ServicoDao dao = new ServicoDao();
	
	@Test
	public void findById(){
		Servico servico = dao.findById(1);
		Assert.assertEquals("Forja de Espada", servico.getDescricao());
	}
}
