package FinalWork;

public interface IList<T> {
	
	public void add(T newEntry);
	public void add(int givenPosition, T newEntry);
	public T remove(int givenPosition);
	public T replace(int givenPosition, T newEntry);
	public T getEntry(int givenPosition);
	public boolean contains(T anEntry);
	public T[] toArray();
	public boolean isEmpty();
	
}
