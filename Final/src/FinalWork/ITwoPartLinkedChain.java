package FinalWork;

public interface ITwoPartLinkedChain<T> {
	
	public boolean isChainFull();
	public T getFront();
	public void enqueue(T newEntry);
	public T dequeue();
	public void clear();
	public boolean isEmpty();

}
