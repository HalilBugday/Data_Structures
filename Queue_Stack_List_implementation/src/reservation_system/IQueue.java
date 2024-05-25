package reservation_system;

public interface IQueue<T>{
	
	public void enqueue(T newEntry);
	public T dequeue() throws EmptyQueueException;
	public T getFront() throws EmptyQueueException;
	public boolean isEmpty();
	public void clear() throws EmptyQueueException;

}
