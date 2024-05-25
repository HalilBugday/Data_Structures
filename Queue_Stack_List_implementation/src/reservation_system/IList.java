package reservation_system;

public interface IList <T>{
	
	public void add(T newEntry);
	public T remove(int givenPosition) throws EmptyListException;
	public void clear() throws EmptyListException;
	public T getEntry(int givenPosition);
	public boolean isEmpty();
	public boolean contains(T anEntry);

}
