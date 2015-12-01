package br.com.cwi.crescer.services.utils;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;

@Service
public class PrecoService {

	public static BigDecimal valorTotal(BigDecimal valor, BigDecimal peso){
		BigDecimal resultado =  valor.multiply(peso);
		return resultado;
	}
	
	public static Pedido calcularNovoPrecoBruto(Pedido pedido, Item item){
		BigDecimal valorFinal = pedido.getValor().add(item.getValorTotal());
		pedido.setValor(valorFinal);
		return pedido;
	}
	
	public static Pedido calcularPrecoFinal(Pedido pedido){
		BigDecimal desconto = calcularDesconto(pedido);
		BigDecimal descontoASerAplicado = pedido.getValor().multiply(desconto);;
		BigDecimal novoValoFinal = pedido.getValor().subtract(descontoASerAplicado);
		pedido.setValorFinal(novoValoFinal);
		pedido.setValorDesconto(descontoASerAplicado);
		return pedido;
	}
	
	private static BigDecimal calcularDesconto(Pedido pedido){
		final BigDecimal descontoPorDataSegundaAQuarta = new BigDecimal(0.08);
		final BigDecimal descontoPorValorEPesoSuperado = new BigDecimal(0.0487);
		final BigDecimal descontoPotDataQuintaESexta = new BigDecimal(0.04);
		
		if(descontoSegundoAQuarta(pedido)){
			return descontoPorDataSegundaAQuarta;
		}
		if(descontoPorValorEPesoSuperado(pedido)){
			return descontoPorValorEPesoSuperado;
		}
		if(descontoQuintaESexta(pedido)){
			return descontoPotDataQuintaESexta;
		}
		return new BigDecimal(0);
	}
	
	private static boolean descontoSegundoAQuarta(Pedido pedido){
		int dia = pedido.getDiaSemana();
		boolean dataSegundaAQuarta = dia == 2 || dia == 3 || dia ==4;
		return dataSegundaAQuarta;
	}
	
	private static boolean descontoPorValorEPesoSuperado(Pedido pedido){
		if(descontoPorValorTotalDoPedido(pedido) || descontoPorPesoDeItens(pedido)){
			return true;
		}
		return false;
	}
	
	private static boolean descontoPorValorTotalDoPedido(Pedido pedido){
		boolean valorMaiorDesconto = pedido.getValor().intValue() > 90;
		return valorMaiorDesconto;
	}
	
	private static boolean descontoPorPesoDeItens(Pedido pedido){
		BigDecimal somatorio = new BigDecimal(0);
		for(Item item : pedido.getItens()){
			somatorio = somatorio.add(item.getPeso());
		}
		Boolean pesoMaiorDesconto = somatorio.doubleValue() > 15;
		return pesoMaiorDesconto;
	}
	
	private static boolean descontoQuintaESexta(Pedido pedido){
		int dia = pedido.getDiaSemana();
		boolean dataQuintaESexta = dia == 5 || dia == 6;
		return dataQuintaESexta;
	}
	

}
