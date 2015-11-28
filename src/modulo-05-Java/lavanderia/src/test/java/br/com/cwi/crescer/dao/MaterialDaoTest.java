package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Material.MaterialDescricao;

public class MaterialDaoTest extends AbstractInfrastructureTest{
	@Autowired
	private MaterialDao dao = new MaterialDao();
	
	@Test
	public void findByIdTest(){
		Material material = dao.findById(21);
		Assert.assertEquals(MaterialDescricao.Delicado, material.getDescricao());
	}
}
