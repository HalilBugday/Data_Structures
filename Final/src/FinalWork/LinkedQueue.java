package FinalWork;

public final class LinkedQueue<T> implements ILinkedQueue<T> {
	
	private Node firstNode;
	private Node lastNode;
	
	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
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

public boolean isEmpty() {
	return (firstNode == null) && (lastNode == null);
}


public void enqueue(T newEntry) {
	Node newNode = new Node(newEntry, null);
	if(isEmpty()) {
		firstNode = newNode;
	}else
		lastNode.setNextNode(newNode);
	lastNode = newNode;
}

public T getFront() {
	if(isEmpty())
		throw new SecurityException("error1");
	else
		return firstNode.getData();
}

public T dequeue() {
	T front = getFront();
	assert firstNode != null;
	firstNode.setData(null);
	firstNode = firstNode.getNextNode();
	if(firstNode == null)
		lastNode = null;
	return front;
}

public void clear() {
	firstNode = null;
	lastNode = null;
}













	
}
