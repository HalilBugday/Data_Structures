package FinalWork;

import java.util.Arrays;

public final class List<T> implements IList<T> {

	private T[] list;
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY=50;
	private static final int MAX_CAPACITY = 10000;
	
	public List() {
		this(DEFAULT_CAPACITY);
	}
	
	public List(int initialCapacity) {
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Object[initialCapacity];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	}
	
	private void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY || capacity <= 0)
			throw new SecurityException("Error1");
	}
	
	private void checkInitialization() {
		if(!initialized)
			throw new IllegalStateException("Error2");
	}
	
	private void ensureCapacity() {
		checkInitialization();
		if(numberOfEntries == list.length) {
			int newCapacity = list.length * 2;
			checkCapacity(newCapacity);
			list = Arrays.copyOf(list, newCapacity);
		}
	}
	
	//opening a new location (to add)
	private void makeRoom(int newPosition) {
		assert(newPosition >= 1) && (newPosition <= numberOfEntries + 1);
		int newIndex = newPosition;
		int lastIndex = numberOfEntries;
		for(int i=lastIndex; i>=newIndex; i--) {
			list[i+1] = list[i];
		}
	}
	
	//close a location (to removed)
	private void removeGap(int givenPosition) {
		assert(givenPosition >= 1) && (givenPosition <= numberOfEntries);
		int lastIndex = numberOfEntries;
		int removedIndex = givenPosition;
		for(int i= removedIndex; i<lastIndex; i++) {
			list[i] = list[i+1];
		}
	}
	
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}
	
	public void add(T newEntry) {
		checkInitialization();
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
		ensureCapacity();
	}
	
	public void add(int newPosition, T newEntry) {
		checkInitialization();
		if((newPosition >= 1) && (newPosition<=numberOfEntries)) {
			makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity();
		
			}else {
				throw new SecurityException("Error3");
		}
	}
	
	public T remove(int givenPosition) {
		checkInitialization();
		if((givenPosition >= 1) && (givenPosition<numberOfEntries)) {
			assert !isEmpty();
			T result = list[givenPosition];
			removeGap(givenPosition);
			numberOfEntries--;
			return result;
		}else {
			throw new SecurityException("Error4");
		}
	}
	
	public T replace(int givenPosition, T newEntry) {
		checkInitialization();
		if((givenPosition >= 1) && (givenPosition<numberOfEntries)) {
			assert !isEmpty();
			T orginalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return orginalEntry;
		}else {
			throw new SecurityException("Error5");
		}
	
	}
	
	public T getEntry(int givenPosition) {
		checkInitialization();
		if((givenPosition >= 1) && (givenPosition<numberOfEntries)) {
			assert !isEmpty();
			T result = list[givenPosition];
			return result;
		}else {
			throw new SecurityException("Error6");
		}
	}
	
	public boolean contains(T anEntry) {
		checkInitialization();
		boolean found = false;
		int index = 1;
		while((!found) && (index < numberOfEntries)) {
			if(anEntry.equals(list[index])) {
				found = true;
				index++;
			}
		}
		return found;
	}
	
	public T[] toArray() {
		checkInitialization();
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for(int i=0; i<numberOfEntries; i++) {
			result[i] = list[i+1];
		}
		return result;
	}
	
	
	
	
	
	
	
	
}
