package FinalWork;

import java.util.Arrays;

public final class Stack<T> implements IStack<T> {
	private T[] stack;
	private int topIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public Stack() {
		this(DEFAULT_CAPACITY);
	}
	
	public Stack(int initialCapacity) {
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		initialized = true;
	}
	
	private void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY || capacity <= 0)
			throw new IllegalStateException("Error1");
	}
	
	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException("Error2");
	}
	
	private void ensureCapacity() {
		if(isFull()) {
			int newLength = 2*stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}
	}
	
	@Override
	public boolean isEmpty() {
		checkInitialization();
		if(topIndex == 0)
			return true;
		else
			return false;
	}
	
	@Override
	public void push(T newEntry) {
		checkInitialization();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}
	
	@Override
	public T pop() {
		checkInitialization();
		if(isEmpty())
			throw new SecurityException("Error3");
		else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}
	@Override
	public T peek() {
		checkInitialization();
		if(isEmpty())
			throw new SecurityException("Error4");
		else
			return stack[topIndex];
	}
	
	@Override
	public boolean isFull() {
		checkInitialization();
		return (topIndex == stack.length -1);
	}
	
	@Override
	public void clear() {
		checkInitialization();
		while(isEmpty()) {
			pop();
		}
	}
	
	
	
	

}
