package reservation_system;

public class Reservations {
	
	private int reservationID;
	private String customerName;
	private String roomType;
	
	public Reservations(int reservationID, String customerName, String roomType)
	{
		this.reservationID = reservationID;
		this.customerName = customerName;
		this.roomType = roomType;
	}

	public int getReservationID() {
		return reservationID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getRoomType() {
		return roomType;
	}
	
	
	
	

}
