package reservation_system;

public class ArrayList <T>implements IList<T> {
	
	private T[] list;
	private int numberOfElements = 0;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 5;
	private static final int MAX_CAPACITY = 1000;
	
	
	public ArrayList()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayList(int initialCapacity)
	{
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Object[initialCapacity];
		list = tempList;
		initialized = true;
		
	}
	

	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		checkInitialization();
		ensureCapacity();
		list[numberOfElements] = newEntry;
		numberOfElements++;
	}

	@Override
	public T remove(int givenPosition) throws EmptyListException {
		// TODO Auto-generated method stub
		checkInitialization();
		T element;
		if(isEmpty())
		{
			throw new EmptyListException("List is empty");
		}
		else {
		checkGivenPosition(givenPosition);
		element = list[givenPosition];
			for(int i  = givenPosition ; i<numberOfElements-1;i++)
			{
				list[i] = list[i+1];
			}
			list[numberOfElements-1] = null;
			numberOfElements--;
		}
		return element;
	}

	@Override
	public void clear() throws EmptyListException {
		// TODO Auto-generated method stub
		while(!isEmpty())
		{
			remove(0);
		}
		
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		checkInitialization();
		checkGivenPosition(givenPosition);
		return list[givenPosition];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfElements==0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		boolean isContain = false;
		for(int i = 0 ;i< numberOfElements;i++)
		{
			if(list[i] == anEntry)
			{
				isContain = true;
			}
		}
		return isContain;
	}
	
	
	
	private void checkCapacity(int capacity) {
		if (capacity <= 0 || capacity > MAX_CAPACITY)
			throw new IllegalStateException("Capacity must be between 1 and " + MAX_CAPACITY);

	}
	
	private void checkInitialization() {
		if (!initialized)
			throw new SecurityException("ArrayList not properly initialized");
	}
	
	private void checkGivenPosition(int givenPosition)
	{
		if(givenPosition <0 || givenPosition >= numberOfElements)
		{
			throw new SecurityException("Given position must be between 0 and " + (numberOfElements-1));
		}
		
	}
	
	
	private void ensureCapacity()
	{
		if(numberOfElements == list.length-1)
		{
			T[] oldQueue = list;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			checkCapacity(newSize);
			
			@SuppressWarnings("unchecked")
			T[] tempList = (T[]) new Object[newSize];
			list = tempList;
			for (int index = 0 ; index<oldSize; index++)
			{
				list[index] = oldQueue[index];
			}	
		}
	}
	
	
	
	public void display()
	{
		int i = 0;
		while(list[i] !=null)
		{
			Rooms room = (Rooms) list[i];
			System.out.println("Room Number: " + room.getRoomNumber() +
							    "| Room Type: " + room.getRoomType() +
							    "| Room Availability: " + room.getAvailability());
			i++;
		}
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	
	
	
	
	
	
	
	

}
