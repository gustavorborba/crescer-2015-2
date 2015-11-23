package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Produto;

public class ProdutoDaoTest extends AbstractInfrastructureTest{
	@Autowired
	ProdutoDao dao = new ProdutoDao();
	@Test
	public void findByIdTest(){
		Produto produto = dao.findById(1);
		Assert.assertNotNull(produto);
	}
}
