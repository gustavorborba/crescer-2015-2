package cwi;

import java.util.ArrayList;

public class LinkedList<T> {
	private Node<T> last,first;
	public void addFirst(T value)
	{
		Node<T> node=new Node<T>(value,first);
		if(first == null){
			last = node;
		}
		first = node;
	}
	public T getFirst()
	{
		return first.getValue();
	}
	public T getLast(){
		return last.getValue();
	}
	
	public ArrayList<T> lista(){
		ArrayList<T> lista= new ArrayList<T>();
		Node<T> node= first;
		while(node != null){
			lista.add(node.getValue());
			node=node.getnext();
			}	
		return lista;
	}
	public int size(){
		int size=0;
		Node<T> node= first;
		while(node != null){
			size++;
			node=node.getnext();
			}
		return size;
	}
	public void addLast(T value){
		Node<T> node = new Node<T>(value);
		if(first == null){
			first=node;
		}
		last.setNext(node);;
		last = node;
	}
	public void removeFirst(){
		first = first.getnext();
	}
	public void remove(int index){
		Node<T> node = this.findNode(index -1);
		Node<T> removido = node.getnext();
		node.setNext(removido.getnext());
	}
	private Node<T> findNode(int index){
		Node<T> node = this.first;
		for(int i=1; i < index;i++){
			node=node.getnext();
		}
		return node;
	}
	public void AddMiddle(int index, T value){
		Node<T> node = findNode(index -1);
		Node<T> nodeAdicionar = new Node<T>(value);
		if(node == first){
			nodeAdicionar.setNext(first);
			first = nodeAdicionar;
		}else{
			nodeAdicionar.setNext(node.getnext());
			node.setNext(nodeAdicionar);
		}
		
	}
	public void AddLast(T value){
		Node<T> node = new Node<T>(value);
		this.last.setNext(node);
		this.last = node;
	}
	protected class Node<U> {
		private U value;
		private Node<U> next;
			public Node(U value,Node<U> next)
			{
				this.value = value;
				this.next = next;
			}
			public Node(U value){
				this.value = value;
			}
			public U getValue(){
				return value;
			}
			public Node<U> getnext(){
				return this.next;
			}
			public void remove(){
				next=null;
			}
			public void setNext(Node<U> next){
				this.next = next;
			}
	}

}
