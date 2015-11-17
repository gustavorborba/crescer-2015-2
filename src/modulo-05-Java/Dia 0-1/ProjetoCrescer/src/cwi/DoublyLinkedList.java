package cwi;

import java.util.ArrayList;

public class DoublyLinkedList<T> implements List<T> {
	private Node<T> first,last;
	
	public void addFirst(T value){
		Node<T> node=new Node<T>(value,first);
		if(this.isEmpty()){
			last = node;
			first = node;
		}else{
			node.setNext(this.first);
			first.setPreview(node);
			first=node;
		}
	}
	public void addLast(T value){
		Node<T> node = new Node<T>(value);
		if(this.isEmpty()){
			this.addFirst(value);
		}else{
			last.setNext(node);
			node.setPreview(last);
			last = node;
		}
	}
	public void AddMiddle(int index, T value){
		Node<T> node = findNode(index);
		if(node == first){
			this.addFirst(value);
		}else if(node == last){
			this.addLast(value);
		}else{
			Node<T> nodeAdicionar = new Node<T>(value);
			nodeAdicionar.setNext(node);
			nodeAdicionar.setPreview(node.getPreview());
			node.getPreview().setNext(nodeAdicionar);
			node.setPreview(nodeAdicionar);
		}
	}
	public void removeFirst(){
		first = first.getNext();
	}
	public void RemoveLast(){
		if(this.last != null){
			Node<T> node = last.getPreview();
			last.setPreview(null);
			last = node;
			last.setNext(null);
		}
	}
	public void remove(int index){
		Node<T> node = this.findNode(index);
		if(node == first){
			this.removeFirst();
		}else if(node == last){
			this.RemoveLast();
		}else{
			Node<T> nodeAuxiliar = node.getPreview();
			nodeAuxiliar.setNext(node.getNext());
			nodeAuxiliar.getNext().setPreview(nodeAuxiliar);
		}
	}
	public T getFirst(){
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
			node=node.getNext();
			}	
		return lista;
	}
	private Node<T> findNode(int index){
		Node<T> node = this.first;
		for(int i=0; i < index;i++){
			node=node.getNext();
		}
		return node;
	}
	
	 public boolean isEmpty() {
	        return first == null;
	    }
	 
	protected class Node<U> {
		private U value;
		private Node<U> next,preview;
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
			public Node<U> getNext(){
				return this.next;
			}
			public Node<U> getPreview(){
				return this.preview;
			}
			public void remove(){
				next=null;
			}
			public void setNext(Node<U> next){
				this.next = next;
			}
			public void setPreview(Node<U> preview){
				this.preview = preview;
			}
	}
	}
