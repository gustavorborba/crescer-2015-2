package cwi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cwi.Dao.ClienteDao;
import cwi.jdbc.ConnectionFactory;
import cwi.model.Cliente;

public class Aplicacao {
	public static void main(String[] args) throws SQLException{
		ClienteDao dao = new ClienteDao();
		Cliente clienteAdd = new Cliente(2,"Chuck Berry","000000");
		List<Cliente> lista= dao.listAll();
		for(Cliente cliente : lista){
			System.out.println(cliente.getNmNome());
		}
		/*
		LinkedList<String> linked = new LinkedList<String>();
		linked.addLast("Odin");
		linked.addLast("Thor");
		linked.addLast("Loky");
		ArrayList<String> lista = linked.lista();
		MenuApp menu = new MenuApp();
		menu.Escrever("C:\\Users\\gustavo.borba\\Desktop\\Arquivo\\arquivo.txt", lista);
		
		
		 * int opcao;
		System.out.println("Digite um para Lista simples");
		System.out.println("Digite dois para lista duplamente encadeada");
		Scanner keyboard = new Scanner(System.in);
		opcao = keyboard.nextInt();
		if(opcao == 1){
			LinkedList<String> lista = new LinkedList<String>();
		}else{
			DoublyLinkedList<String> lista = new DoublyLinkedList<String>();
		}
		System.out.println("Menu");
		System.out.println("1- listar todos dados");
		System.out.println("2 - Inserir novos dados");
		System.out.println("3 - Deletar dados");
		System.out.println("4 -Ler Arquivo");
		*/
	}
}
