package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Item;


public class ItemDaoTest extends AbstractInfrastructureTest{
	@Autowired
	private ItemDao dao = new ItemDao();
	
	@Test
	public void findByIdTest(){
		Item item = dao.findById(1);
		Assert.assertNotNull(item);
	}
}
