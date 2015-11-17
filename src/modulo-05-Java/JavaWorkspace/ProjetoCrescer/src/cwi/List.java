package cwi;

import java.util.ArrayList;

public interface List<T> {
	public void addFirst(T value);
	public void addLast(T value);
	public void AddMiddle(int index, T value);
	public void removeFirst();
	public void RemoveLast();
	public void remove(int index);
	public T getFirst();
	public T getLast();
	public ArrayList<T> lista();
	public boolean isEmpty();
	 
}
