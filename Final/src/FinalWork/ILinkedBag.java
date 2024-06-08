package FinalWork;

public interface ILinkedBag<T> {
	
	public boolean add(T newEntry);
	public T[] toArray();
	public int getFrequencyOf(T anEntry);
	public boolean contains(T anEntry);
	public boolean remove(T anEntry);
	public boolean isEmpty();

}
