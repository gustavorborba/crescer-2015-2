package br.com.cwi.crescer.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Authorities;
import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.domain.Users.SituacaoUsuario;


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
	@Test
	public void salvarTest(){
		Users user = new Users();
		user.setPassword("asda");
		user.setUsername("Odin");
		user.setUsuarioSituacao(SituacaoUsuario.ATIVO);
		Authorities autho = new Authorities();
		autho.setAuthority("ROLE_ADMIN");
		autho.setUsername(user);
		dao.salvarNovo(autho);
		
		int esperado = dao.listAll().size();
		
		Assert.assertEquals(esperado, 3);
	}
}
