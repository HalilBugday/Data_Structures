package FinalWork;

public interface IStack<T> {
	
	public void push(T newEntry);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public boolean isFull();
	public void clear();
	
}
