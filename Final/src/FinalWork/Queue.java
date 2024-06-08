package FinalWork;

public final class Queue<T> implements IQueue<T> {

	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public Queue() {
		this(DEFAULT_CAPACITY);
	}
	
	public Queue(int initialCapacity) {
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queue=tempQueue;
		frontIndex = 0;
		backIndex = frontIndex -2;
		initialized = true;
	}
	
	private void checkCapacity(int capacity) {
		if(capacity <= 0 || capacity > MAX_CAPACITY)
			throw new IllegalStateException("Error1");
	}
	
	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException("Error2");
	}
	
	private void ensureCapacity() {
		checkInitialization();
		if(frontIndex == ((backIndex + 2) % queue.length)) {
			T[] oldQueue = queue;
			int oldSize = queue.length;
			int newSize = queue.length * 2;
			checkCapacity(newSize);
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for(int i=0; i<oldSize -1; i++) {
				queue[i] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = frontIndex -2;
		}
	}
	
	@Override
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % queue.length);
		
	}
	
	@Override
	public void enqueue(T newEntry) {
		checkInitialization();
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}
	
	@Override
	public T dequeue() {
		checkInitialization();
		if(isEmpty()) {
			throw new SecurityException("Error3");
		}else { 
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		}
	}
	
	@Override
	public T getFront() {
		checkInitialization();
		if(isEmpty())
			throw new SecurityException("Error4");
		else
			return queue[frontIndex];
	}
	
	@Override
	public void clear() {
		checkInitialization();
		while(!isEmpty()) {
			dequeue();
		}
	}
	
}
