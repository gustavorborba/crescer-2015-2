package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cwi.LinkedList;

public class Testes {

	@Test
	public void adicionarPrimeiroNaLista() {
		LinkedList linkedList = new LinkedList();
		linkedList.addFirst("primeiro");
		linkedList.addFirst("segundo");
		assertEquals(linkedList.getFirst(),"segundo");
		assertEquals(linkedList.getLast(),"primeiro");
	}

}
