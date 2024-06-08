package FinalWork;

public class TwoPartLinkedChain<T> implements ITwoPartLinkedChain<T>{
	
	private Node queueNode; //first node
	private Node freeNode; //after back queue
	
	public TwoPartLinkedChain() {
		freeNode = new Node(null, null);
		freeNode.setNextNode(freeNode);
		queueNode = freeNode;
		
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
	
	public boolean isChainFull() {
		return queueNode == freeNode.getNextNode();
	}	
	
	public boolean isEmpty() {
		return queueNode == freeNode;
	}
	
	public void enqueue(T newEntry) {
		freeNode.setData(newEntry);
		if(isChainFull()) {
			Node newNode = new Node(null, freeNode.getNextNode());
			freeNode.setNextNode(newNode);
			freeNode = freeNode.getNextNode();
		}
		
	}
	
	public T getFront() {
		if(isEmpty()){
			throw new SecurityException("error1");
		}else
			return queueNode.getData();
	}
	
	public T dequeue() {
		T front = getFront();
		assert !isEmpty();
		queueNode.setData(null);
		queueNode = queueNode.getNextNode();
		return front;
		
	}
	
	public void clear() {
		assert !isEmpty();
		while(!isEmpty()) {
			dequeue();
		}
	}
}
