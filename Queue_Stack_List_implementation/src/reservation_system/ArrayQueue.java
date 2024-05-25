package reservation_system;
public class ArrayQueue <T> implements IQueue<T> {
	
	private T[] queue;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 5;
	private static final int MAX_CAPACITY = 10000;
	private int numberOfElements = 0;
	
	
	public ArrayQueue()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayQueue(int initialCapacity)
	{
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity];
		queue = tempQueue;
		initialized = true;
	}
	
	
	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		
		checkInitialization();
		ensureCapacity();
		queue[numberOfElements] = newEntry;
		numberOfElements++;
		
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		
		checkInitialization();
		
		if(isEmpty())
			throw new EmptyQueueException("Queue is Empty");
		else
		{
			T front = queue[0];
			for(int i = 0 ;i<numberOfElements-1;i++)
			{
				queue[i] = queue[i+1];
			}
			queue[numberOfElements-1] = null;
			numberOfElements--;
			return front;
		}
	}

	@Override
	public T getFront() throws EmptyQueueException {
		// TODO Auto-generated method stub
		
		checkInitialization();
		
		if(isEmpty())
			throw new EmptyQueueException("Queue is empty");
		else
			return queue[0];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfElements == 0;
	}

	@Override
	public void clear() throws EmptyQueueException {
		// TODO Auto-generated method stub
		checkInitialization();
		while(!isEmpty())
		{
			dequeue();
		}
		
	}
	private void ensureCapacity()
	{
		if(numberOfElements == queue.length-1)
		{
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			checkCapacity(newSize);
			
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for (int index = 0 ; index<oldSize; index++)
			{
				queue[index] = oldQueue[index];
			}	
		}
	}
	
	private void checkCapacity(int capacity) {
		if (capacity <= 0 || capacity > MAX_CAPACITY)
			throw new IllegalStateException("Capacity must be between 1 and " + MAX_CAPACITY);

	}
	
	private void checkInitialization() {
		if (!initialized)
			throw new SecurityException("ArrayStack not properly initialized");
	}
	
	public void display()
	{
		
		int i = 0 ;
		while(queue[i]!=null)
		{
			Reservations reservation = (Reservations) queue[i];
			System.out.println("Reservation ID: " + reservation.getReservationID() +
							   "| Reservation Customer Name: " + reservation.getCustomerName()+
							   "| Reservation Room Type: " + reservation.getRoomType());
			
			i++;
		}

		
		
	}


	
	
}
