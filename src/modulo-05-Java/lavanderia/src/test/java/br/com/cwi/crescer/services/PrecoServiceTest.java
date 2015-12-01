package br.com.cwi.crescer.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.cwi.crescer.AbstractInfrastructureTest;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.services.utils.PrecoService;

public class PrecoServiceTest extends AbstractInfrastructureTest{
	
	@Test
	public void segundaFeiraDesconto() throws ParseException{
		Pedido pedido = new Pedido();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date sexta = format.parse("30/11/2015");
		pedido.setDataInclusao(new Date());
		pedido.setValorFinal(new BigDecimal(10));
		
		Pedido pedidoFinal = PrecoService.calcularPrecoFinal(pedido);
		double esperado =pedidoFinal.getValorFinal().doubleValue();
		
		Assert.assertEquals(9.2, esperado,0.0000001);
	}
	
	@Test
	public void pesoLimiteDesconto() throws ParseException{
		Pedido pedido = new Pedido();
		Item item = new Item();
		item.setPeso(new BigDecimal(16));
		pedido.getItens().add(item);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date sabado = format.parse("28/11/2015");
		pedido.setDataInclusao(sabado);
		pedido.setValorFinal(new BigDecimal(10));
		
		double esperado = PrecoService.calcularPrecoFinal(pedido).getValorFinal().doubleValue();
		
		Assert.assertEquals(9.513, esperado,0.0000001);
	}
	
	@Test
	public void somaTotalDesconto() throws ParseException{
		Pedido pedido = new Pedido();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date sabado = format.parse("05/12/2015");
		pedido.setDataInclusao(sabado);
		pedido.setValorFinal(new BigDecimal(95));
		
		Pedido pedidoFinal = PrecoService.calcularPrecoFinal(pedido);
		BigDecimal valorFinal = pedidoFinal.getValorFinal();
		BigDecimal valorDiferenca = new BigDecimal(95).subtract(valorFinal);
		
		Assert.assertEquals(90.3735, valorFinal.doubleValue(),0.000001);
		Assert.assertEquals(pedidoFinal.getValorDesconto(),valorDiferenca);
	}
	
	@Test
	public void sextaFeiraDesconto() throws ParseException{
		Pedido pedido = new Pedido();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date sexta = format.parse("04/12/2015");
		pedido.setDataInclusao(sexta);
		pedido.setValorFinal(new BigDecimal(10));
		
		Pedido pedidoFinal = PrecoService.calcularPrecoFinal(pedido);
		
		double esperado = pedidoFinal.getValorFinal().doubleValue();
		Assert.assertEquals(9.6, esperado,0.00001);
	}
	@Test
	public void calcularNovoPreco(){
		Pedido pedido = new Pedido();
		pedido.setValor(new BigDecimal(20));
		Item item = new Item();
		item.setValorTotal(new BigDecimal(55.5));
		
		Pedido pedidoFinal = PrecoService.calcularNovoPrecoBruto(pedido, item);
		
		BigDecimal esperado = new BigDecimal(75.5);
		Assert.assertEquals(esperado, pedidoFinal.getValor());
	}
	@Test
	public void multiplicarDoisValores(){
		BigDecimal valor1 = new BigDecimal(2);
		BigDecimal valor2 = new BigDecimal(200);
		
		BigDecimal multiplicado = PrecoService.valorTotal(valor1, valor2);
		
		BigDecimal esperado = new BigDecimal(400);
		
		Assert.assertEquals(multiplicado, esperado);
	}
}
