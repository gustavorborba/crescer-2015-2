package br.com.cwi.crescer.mavin;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Test;

public class MatematicaTest {
	@Test
	public void testarSoma(){
		int resultado = new Matematica().somar(1, 1);
		Assert.assertEquals(2, resultado);
	}
}
