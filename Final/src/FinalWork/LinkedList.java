package FinalWork;

public final class LinkedList<T> implements ILinkedList<T> {
	private Node firstNode;
	private Node lastNode;
	
	private int numberOfNodes;
	private int numberOfEntries;
	
	public LinkedList() {
		firstNode = null;
		numberOfNodes = 0;
		lastNode = null;
		numberOfEntries = 0;
		
	}

	private class Node{
		
		private T data; //entry in the bag
		private Node next; //link to next node
		
		private Node(T dataPortion) {
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		
		private T getData() {
			return data;
		}
		
		@SuppressWarnings("unused")
		private void setData(T newData) {
			data = newData;
		}
		
		private Node getNextNode() {
			return next;
		}
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
	}
	
	private Node getNodeAt(int givenPosition) {
		
		assert(firstNode != null) && (1<=givenPosition) && (givenPosition <= numberOfNodes);
		Node currentNode = firstNode;
		
		for(int counter = 1; counter < givenPosition; counter++) {
			currentNode = currentNode.getNextNode();
			assert currentNode != null;
		}
		return currentNode;
	}
	
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while(!found && (currentNode != null)) {
			if(anEntry.equals(currentNode.getData()))
				found=true;
			else
				currentNode = currentNode.getNextNode();
		}
		return found;
	}
	
	public boolean isEmpty() {
		boolean result;
		if(numberOfEntries == 0) {
			assert firstNode == null;
			result= true;
		}else {
			assert firstNode != null;
			result = false;
		}
		return result;
	}
	
	public T getEntry(int givenPosition) {
		if((givenPosition >=1 ) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return getNodeAt(givenPosition).getData();
		}else
			throw new IndexOutOfBoundsException("Error3");
	}
	
	//adding to the End of the List
	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
		numberOfEntries++;
	}
	
	//adding at a Given Position
	public void add(int newPosition, T newEntry) {
		
		if((newPosition >=1 ) && (newPosition <= numberOfEntries+1)) {
			Node newNode = new Node(newEntry);
			if(isEmpty()) {
				firstNode = newNode;
				lastNode = newNode;
			}
			else if(newPosition == 1) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else if(newPosition == numberOfEntries +1) {
				lastNode.setNextNode(newNode);
				lastNode = newNode;
			}
			else {
				Node nodeBefore = getNodeAt(newPosition -1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
			
		}else
			throw new IndexOutOfBoundsException("Error1");
		
	}
	
	public T remove(int givenPosition) {
		T result = null;
		if((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			if(givenPosition ==1) {
				result = firstNode.getData();
				firstNode = firstNode.getNextNode();
				if(numberOfEntries ==1)
					lastNode = null;
			}else {
				Node nodeBefore = getNodeAt(givenPosition -1);
				Node nodeToRemove = nodeBefore.getNextNode();
				@SuppressWarnings("unused")
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.getData();
				if(givenPosition == numberOfEntries)
					lastNode = nodeBefore;
			}
			numberOfEntries--;
		}else
			throw new IndexOutOfBoundsException("Error2");
		return result;
	}
	
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		
		int index = 0;
		Node currentNode = firstNode;
		while((index<numberOfEntries) && (currentNode !=null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		return result;
	}
	
}
