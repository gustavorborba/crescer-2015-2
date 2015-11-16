package cwi;

public class Node<T> {
	private T value;
	private Node<T> next;
		public Node(T value,Node<T> next)
		{
			this.value = value;
			this.next = next;
		}
		public Node(T value){
			this.value = value;
		}
		public T getValue(){
			return value;
		}
		public Node<T> getnext(){
			return this.next;
		}
		public void remove(){
			next=null;
		}
		public void setNext(Node<T> next){
			this.next = next;
		}
}
