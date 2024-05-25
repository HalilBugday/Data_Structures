package reservation_system;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements IStack<T>{
	

	private static final int DEFAULT_CAPACITY = 5;
	private static final int MAXIMUM_CAPACITY = 10000;

	private int numberOfEntries;
	private T[] stack;
	private boolean initialized = false;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int initialCapacity) {
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[initialCapacity];
		stack = temp;
		numberOfEntries = 0;
		initialized = true;
	}

	private void checkCapacity(int capacity) {
		if (capacity <= 0 || capacity > MAXIMUM_CAPACITY)
			throw new IllegalStateException("Capacity must be between 1 and " + MAXIMUM_CAPACITY);

	}

	private void checkInitialized() {
		if (!initialized)
			throw new SecurityException("ArrayStack not properly initialized");
	}

	private void resizeArray() {
		if (numberOfEntries == stack.length-1) {
			int newSize = stack.length * 2;
			checkCapacity(newSize);
			// makes copy of array, but with the new size
			stack = Arrays.copyOf(stack, newSize);
		}
	}

	@Override
	public void push(T newEntry) {
		checkInitialized();
		resizeArray();
		stack[numberOfEntries] = newEntry;
		numberOfEntries++;
	}

	@Override
	public T pop() {
		checkInitialized();
		if (numberOfEntries == 0) { // isEmpty()
			throw new EmptyStackException();
		} else {
			T result = stack[numberOfEntries-1];
			stack[numberOfEntries-1] = null;
			numberOfEntries--;
			return result;
		}
	}

	@Override
	public T peek() {
		checkInitialized();
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return stack[numberOfEntries-1];
		}
	}

	@Override
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}

	@Override
	public void clear() {
		checkInitialized();
		while (!isEmpty()) {
			pop();
		}
	}
	

	public void display()
	{
		
		int i = numberOfEntries-1 ;
		while(i!=-1)
		{
			Rooms room = (Rooms) stack[i];
			System.out.println("Room Number: " + room.getRoomNumber() +
							   "| Room Type: " + room.getRoomType() + 
							   "| Room Availability: "+ room.getAvailability());
			i--;
		}
		
		
	}
	
	
	
}
