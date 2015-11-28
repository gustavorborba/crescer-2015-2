package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Material;

public class MaterialDaoTest extends AbstractInfrastructureTest{
	@Autowired
	private MaterialDao dao = new MaterialDao();
	
	@Test
	public void listAll(){
		int size = dao.listarTodosMateriais().size();
		
		Assert.assertEquals(3, size);
	}
}
