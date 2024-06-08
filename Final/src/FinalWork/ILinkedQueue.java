package FinalWork;

public interface ILinkedQueue<T> {

	public void enqueue(T newEntry);
	public T getFront();
	public T dequeue();
	public boolean isEmpty();
	public void clear();
	
}
