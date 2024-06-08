package FinalWork;

public interface IQueue<T> {
	
	public boolean isEmpty();
	public T getFront();
	public void enqueue(T newEntry);
	public T dequeue();
	public void clear();

}
