package FinalWork;

import java.util.Arrays;

public final class Bag<T> implements IBag<T> {
	
	private T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	private boolean initialized = false;
	private static final int MAX_CAPACITY = 10000;
	
	public Bag() {
		this(DEFAULT_CAPACITY);
	}
	
	public Bag(int desiredCapacity) {
		if (desiredCapacity <= MAX_CAPACITY && desiredCapacity >= 1) {
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[]) new Object[desiredCapacity];
			bag = tempBag;
			numberOfEntries = 0;
			initialized = true;
		}else
			throw new IllegalStateException("Error1");
	}

	private void checkInitialization() {
		if(!initialized) {
			throw new SecurityException("Error2");
		}
	}
	
	private void doubleCapacity() {
		checkInitialization();
		if(isFull()) {
			bag = Arrays.copyOf(bag, bag.length*2);
		}
	}
	
	@Override
	public boolean isFull() {
		checkInitialization();
		if(numberOfEntries == bag.length) {
			return true;
		}else
			return false;
	}
	
	@Override
	public boolean isEmpty() {
		checkInitialization();
		if(numberOfEntries == 0) {
			return true;
		}else
			return false;
	}
	
	@Override
	public boolean add(T newEntry) {
		checkInitialization();
		if(isFull()) {
			doubleCapacity();
		}
		bag[numberOfEntries] = newEntry;
		numberOfEntries++;
		return true;
	}
	
	@Override
	public T removeByIndex(int index) {
		checkInitialization();
		T result = null;
		if(!isEmpty() && (index >= 0)) {
			result = bag[index];
			numberOfEntries--;
			bag[index] = bag[numberOfEntries];
			bag[numberOfEntries] = null;
		}
		return result;
	}
	
	@Override
	public int getIndexOf(T anEntry) {
		checkInitialization();
		for(int i=0; i<numberOfEntries; i++) {
			if(bag[i].equals(anEntry)){
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public boolean remove(T anEntry) {
		checkInitialization();
		int index = getIndexOf(anEntry);
		T result = bag[index];
		return anEntry.equals(result);
	}
	
	@Override
	public T remove() {
		checkInitialization();
		T result = null;
		if(numberOfEntries > 0) {
			result = bag[numberOfEntries -1];
			bag[numberOfEntries -1] = null;
			numberOfEntries--;
		}
		return result;
	}
	
	@Override
	public int getFrequencyOf(T anEntry) {
		checkInitialization();
		int counter = 0;
		for(int index = 0; index < numberOfEntries; index++) {
			if(anEntry.equals(bag[index])) {
				counter++;
			}
		}
		return counter;
	}
	
	@Override
	public boolean contains(T anEntry) {
		checkInitialization();
		if(getIndexOf(anEntry) > -1) {
			return true;
		}else
			return false;
	}
	
	@Override
	public void clear() {
		checkInitialization();
		while(!isEmpty()) {
			remove();
		}
	}
	
	@Override
	public void displayItems() {
		checkInitialization();
		for(int i=0; i<numberOfEntries; i++) {
			System.out.println(bag[i] + " ");
		}
	}
	
	@Override
	public int getCurrentSize() {
		checkInitialization();
		return numberOfEntries;
	}
	
	@Override
	public T[] toArray() {
		checkInitialization();
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for(int index = 0; index<numberOfEntries; index++) {
			result[index] = bag[index];
		}
		return result;
	}	
	
}
