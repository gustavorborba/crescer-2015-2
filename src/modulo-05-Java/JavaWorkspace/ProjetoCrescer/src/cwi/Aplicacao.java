package cwi;

import java.util.ArrayList;

public class Aplicacao {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addFirst("primeiro");
		linkedList.addFirst("segundo");
		linkedList.addFirst("terceiro");
		linkedList.AddMiddle(0,"Joao");
		linkedList.addLast("Borba");
		ArrayList<String> lista=linkedList.lista();
		
		for(String value : lista){
			System.out.println(value);
		}
		System.out.println(linkedList.lista().size());
		
	}
}
