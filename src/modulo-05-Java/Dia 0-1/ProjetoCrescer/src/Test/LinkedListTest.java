package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cwi.LinkedList;

public class LinkedListTest {

	@Test
	public void adicionarPrimeiroNaLista() {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addFirst("Segundo");
		linkedList.addFirst("Terceiro");
		linkedList.addFirst("Quarto");
		linkedList.addLast("Quinto");
		assertEquals(linkedList.getFirst(),"Quarto");
		assertEquals(linkedList.getLast(),"Quinto");
	}
	@Test
	public void adicionarAoFinal(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("Segundo");
		assertEquals(linkedList.getFirst(),"primeiro");
		assertEquals(linkedList.getLast(),"Segundo");
	}
	@Test
	public void adicionarAoFinal2(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("Segundo");
		linkedList.addFirst("Quarto");
		linkedList.addFirst("Terceiro");
		linkedList.addLast("Quinto");
		assertEquals(linkedList.getFirst(),"Terceiro");
		assertEquals(linkedList.getLast(),"Quinto");
	}
	@Test
	public void adicionarAoMeio(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addFirst("Segundo");
		linkedList.addFirst("Terceiro");
		linkedList.AddMiddle(1, "MEIO");
		ArrayList<String> lista= linkedList.lista();
		assertEquals(lista.get(1),"MEIO");
		assertEquals(lista.get(0),"Terceiro");
	}
	@Test
	public void adicionarAoMeioDiversasSituacoes(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addLast("Quinto");
		linkedList.addFirst("Segundo");
		linkedList.addFirst("Terceiro");
		linkedList.addLast("Quarto");
		linkedList.addFirst("Terceiro");
		linkedList.AddMiddle(1, "MEIO");
		linkedList.addFirst("Sexto");
		ArrayList<String> lista= linkedList.lista();
		assertEquals(lista.get(2),"MEIO");
		assertEquals(lista.size(),8);
	}
	@Test
	public void returnList(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addFirst("segundo");
		ArrayList<String> lista= linkedList.lista();
		assertEquals(lista.get(0),"segundo");
		assertEquals(lista.get(1),"primeiro");
	}
	@Test
	public void removeFirst(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addLast("primeiro");
		linkedList.addLast("segundo");
		linkedList.removeFirst();
		assertEquals(linkedList.getFirst(), "segundo");
		assertEquals(linkedList.getLast(),"segundo");
	}
	@Test
	public void removeLast(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addLast("primeiro");
		linkedList.addLast("segundo");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.RemoveLast();
		assertEquals(linkedList.getFirst(),"primeiro");
		assertEquals(linkedList.getLast(),"terceiro");
	}
	@Test
	public void removePorIndex(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addLast("primeiro");
		linkedList.addLast("segundo");
		linkedList.addLast("terceiro");
		linkedList.addLast("quarto");
		linkedList.remove(2);
		ArrayList<String> lista= linkedList.lista();
		assertEquals(lista.get(2),"quarto");
		assertEquals(lista.get(1),"segundo");
		assertEquals(lista.size(),3);
	}
}
