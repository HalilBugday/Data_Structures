package FinalWork;

public final class LinkedBag<T>  implements ILinkedBag<T>{
	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedBag() {
		firstNode = null;
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
		
		@SuppressWarnings("unused")
		private T getData() {
			return data;
		}
		
		@SuppressWarnings("unused")
		private void setData(T newData) {
			data = newData;
		}
		
		@SuppressWarnings("unused")
		private Node getNextNode() {
			return next;
		}
		@SuppressWarnings("unused")
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
	}
	
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}
	
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int loopCounter = 0;
		Node currentNode = firstNode;
		while((loopCounter < numberOfEntries) && (currentNode != null)) {
			if(anEntry.equals(currentNode.data))
				frequency++;
			loopCounter++;
			currentNode = currentNode.next;
		}
		return frequency;
	}
	
	public boolean contains(T anEntry) {
		boolean found=false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)) {
			if(anEntry.equals(currentNode)) {
				found = true;
			}else {
				currentNode = currentNode.next;
			}
		}
		return found;
	}
	
	//to detect remove entry location
	private Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while(!found && (currentNode != null)) {
			if(anEntry.equals(currentNode.data)) {
				found = true;
			}else{
				currentNode = currentNode.next;
			}
		}
		return currentNode;
	}
	
	public boolean remove(T anEntry) {
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);
		if(nodeN != null) {
			nodeN.data = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
			result=true;
		}
		return result;
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
	
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		int index = 0;
		Node currentNode = firstNode;
		while((index<numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		return result;
		
	}
}
