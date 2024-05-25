package reservation_system;

public class Rooms {
	
	private int roomNumber;
	private String roomType;
	private boolean availability;
	
	public Rooms(int roomNumber,String roomType, boolean availability)
	{
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.availability = availability;
	}

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}
	
	
	
	

}
