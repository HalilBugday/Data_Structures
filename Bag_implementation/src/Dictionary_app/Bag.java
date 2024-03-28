package Dictionary_app;

import java.util.Arrays;

public class Bag <T> implements IBag <T> {

	private T[] bagArray;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10000;
	private boolean initialized = false;
	
public Bag() {
	
	this(DEFAULT_CAPACITY);
}
public Bag(int desiredCapacity) {
	if(desiredCapacity <= MAX_CAPACITY && desiredCapacity >=1 ) {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[desiredCapacity];
		bagArray = tempBag;
		numberOfEntries=0;
		initialized = true;
	}else {
		throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum! "
				+ "Or the initialized bag size is not positive integer!");
    }
}

public void checkInitialization() {
	if(!initialized) {
		throw new SecurityException("ArrayBag object is not initialized properly!");
	}
}

public void doubleCapacity() {
	checkInitialization();
	if(isFull()) {
		bagArray = Arrays.copyOf(bagArray, bagArray.length*2);
	}
}

@Override
public boolean isFull() {
	checkInitialization();
	if(numberOfEntries==bagArray.length) {
		return true;
	}else {
		return false;
	}
}

@Override
public boolean isEmpty() {
	checkInitialization();
	if(numberOfEntries==0) {
		return true;
	}else {
		return false;
	}
}

@Override
public boolean add(T newEntry) {
	checkInitialization();
	if(isFull()) {
		doubleCapacity();
	}
	bagArray[numberOfEntries] = newEntry;
	numberOfEntries++;
	return true;
}

@Override
public T removeByIndex(int index) {
	checkInitialization();
	T result = null;
    if (!isEmpty() && (index >=0))
    {
        result = bagArray[index];
        numberOfEntries--;
        bagArray[index] = bagArray[numberOfEntries];
        bagArray[numberOfEntries] = null;
     }
    return result;
}

@Override
public boolean remove(T anEntry) {
	checkInitialization();
	int index = getIndexOf(anEntry);
	T result = removeByIndex(index);
	return anEntry.equals(result);
}

@Override
public T remove() {
	checkInitialization();
	T result = null;
	if(numberOfEntries > 0) {
		result = bagArray[numberOfEntries - 1];
		bagArray[numberOfEntries - 1]= null;
		numberOfEntries--;
	}
	return result;
}

@Override
public int getFrequencyOf(T anEntry) {
	checkInitialization();
	int counter = 0;
	for(int index = 0; index<numberOfEntries; index++) {
		if(anEntry.equals(bagArray[index])) {
			counter++;
		}
	}
	return counter;
}

@Override
public int getIndexOf(T anEntry) {
	checkInitialization();
    for (int i = 0; i < numberOfEntries; i++) {
        if (bagArray[i].equals(anEntry)) {
            return i;
        }
    }
    return -1;
}

@Override
public boolean contains(T anEntry) {
	checkInitialization();
	if(getIndexOf(anEntry) > -1) {
		return true;
	}else {
		return false;
	}
}

@Override
public void clear() {
	while(!isEmpty()) {
		remove();
	}
}

@Override
public void displayItems() {
	checkInitialization();
    for (int i = 0; i < numberOfEntries; i++) {
        System.out.print(bagArray[i]+" ");
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
     T[] result =(T[])new Object[numberOfEntries];
     for (int index=0; index<numberOfEntries; index++)
     {
         result[index]=bagArray[index];
     }
     return result;
}
}
