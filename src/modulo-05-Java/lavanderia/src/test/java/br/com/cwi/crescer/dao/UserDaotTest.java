package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Users;

public class UserDaotTest extends AbstractInfrastructureTest{
	@Autowired
	private UsersDao dao = new UsersDao();
	
	@Test
	public void findByIdTest(){
		Users users= dao.findByUsername("user");
		Assert.assertNotNull(users);
		
	}
}
