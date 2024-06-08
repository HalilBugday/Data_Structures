package FinalWork;

public interface ILinkedList<T> {
	
	public boolean contains(T anEntry);
	public boolean isEmpty();
	public T getEntry(int givenPosition);
	public void add(T newEntry);
	public void add(int newPosition, T newEntry);
	public T remove(int givenPosition);
	public T[] toArray();

}
