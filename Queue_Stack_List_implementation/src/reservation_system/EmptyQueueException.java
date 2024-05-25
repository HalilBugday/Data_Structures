package reservation_system;

public class EmptyQueueException  extends Exception {
	
	public EmptyQueueException (String errorMessage)
	{
		super(errorMessage);
	}

}
