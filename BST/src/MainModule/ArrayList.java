package MainModule;
import java.util.Arrays;

public class ArrayList<T> implements IArrayList<T> {
    private T[] arrayList;;
    private int numberOfElements;
    private boolean initialized;
    private static final int DEFAULT_CAPACITY = 5;
    private static final int MAX_CAPACITY = 10000;

    public ArrayList() {
    	this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
    	checkCapacity(initialCapacity);
    	@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Object[initialCapacity];
        arrayList = tempList;
        numberOfElements = 0;
        initialized = true;
    }

    private void checkInitialized() {
    	if(!initialized)
    		throw new SecurityException("The constructor not initialized!");
    }

    private void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY || capacity <= 0)
			throw new IndexOutOfBoundsException("The given capacity is higher than max capacity or less than (or equal) to zero!");
	}

    private void doubleArray() {
    	checkInitialized();
    	if (numberOfElements == arrayList.length) {
            int newCapacity = arrayList.length * 2;
            checkCapacity(newCapacity);
            arrayList = Arrays.copyOf(arrayList, newCapacity);
        }
    }

    @Override
    public void add(T item) {
    	checkInitialized();
    	doubleArray();
        arrayList[numberOfElements++] = item;
    }

    public boolean isEmpty() {
    	return numberOfElements == 0;
    }

    @Override
    public T get(int index) {
    	checkInitialized();
    	T result;
        if (index >= numberOfElements || index < 0) {
            throw new IndexOutOfBoundsException("The given index out of bounds of the list!");
        }
        result = (T) arrayList[index];
        return result;
    }

    @Override
    public int getCurrentSize() {
    	if(isEmpty()) {
    		throw new SecurityException("The list is empty!");
    	}
    	checkInitialized();
        return numberOfElements;
    }
}
