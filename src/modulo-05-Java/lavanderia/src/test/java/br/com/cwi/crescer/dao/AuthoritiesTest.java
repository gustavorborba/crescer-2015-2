package br.com.cwi.crescer.dao; 

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Authorities;


public class AuthoritiesTest extends AbstractInfrastructureTest {
	@Autowired
	AuthoritiesDao dao = new AuthoritiesDao();
	@Autowired
	UsersDao userDao = new UsersDao();
	
	@Test
	public void listAllTest(){
		List<Authorities> lista = dao.listAll();
		Assert.assertNotNull(lista);
	}
}
