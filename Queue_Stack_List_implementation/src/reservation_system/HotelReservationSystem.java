package reservation_system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HotelReservationSystem {
	
	
	 private static ArrayStack<Rooms> singleRooms = new ArrayStack<>();
	 private static ArrayStack<Rooms> doubleRooms = new ArrayStack<>();
	 private static ArrayStack<Rooms> suiteRooms = new ArrayStack<>();
	 private static ArrayStack<Rooms> deluxeRooms = new ArrayStack<>();
	 
	 
	 private static ArrayQueue<Reservations> singleWaitingLine = new ArrayQueue<>();
	 private static ArrayQueue<Reservations> doubleWaitingLine = new ArrayQueue<>();
	 private static ArrayQueue<Reservations> suiteWaitingLine = new ArrayQueue<>();
	 private static ArrayQueue<Reservations> deluxeWaitingLine = new ArrayQueue<>();
	 
	 private static ArrayList<Rooms> bookedRooms = new ArrayList<>();
	 private static ArrayList<Rooms> availableRooms = new ArrayList<>();
	 private static ArrayList<Rooms> unavailableRooms = new ArrayList<>();

	public static void sortForList(ArrayStack<Rooms> rooms ) throws EmptyListException
	{
		
		ArrayList<Rooms> roomList = new ArrayList<Rooms>();
		while(!rooms.isEmpty())
		{
			roomList.add(rooms.pop());
		}
		
		boolean isSort = false;
		
		while(!isSort)
		{
			int total = roomList.getNumberOfElements();
			int control = 0;
			for(int j = 0 ; j<total-1;j++)
			{
				if(roomList.getEntry(j).getRoomNumber()<roomList.getEntry(j+1).getRoomNumber())
				{
					Rooms removedRoom = roomList.remove(j);
					roomList.add(removedRoom);
				}
				else {
					control++;
					if(control == roomList.getNumberOfElements()-1)
					{
						isSort=true;
					}
				}
				
				
			}
			
		}
		while(!roomList.isEmpty())
		{
			rooms.push(roomList.remove(0));
		}

	}
	
	
	public static void createPileOfRooms()
	{
		
		
		 for(int i  = 5; i>=1; i--)
		 {
			 singleRooms.push(new Rooms(i,"Single",true));
		 }
		 
		 for(int i = 10; i >=6;i--)
		 {
			 doubleRooms.push(new Rooms(i,"Double",true));
		 }
		 
		 for(int i = 15 ; i>=11;i--)
		 {
			 suiteRooms.push(new Rooms(i,"Suite",true));
		 }
		 
		 for(int i = 20 ; i>=16;i--)
		 {
			 deluxeRooms.push(new Rooms(i,"Deluxe",true));
		 }
		
		
		
		
	}
	
	public static void readFile()
	{
		 try (BufferedReader reader = new BufferedReader(new FileReader("reservations.txt"))) {
	           String line;
	           reader.readLine();
	           while ((line = reader.readLine()) != null) {
	        	   String[] parts = line.split(",");     	   
	        	   int reservationID = Integer.parseInt(parts[0]);
	        	   String customerName = parts[1];
	        	   String roomType = parts[2];
	        	   Reservations reservation;
	        	   switch(roomType) {
	       	  
	        	   case "Single":
	        		   if(!singleRooms.isEmpty())
	        		   {
	        			  Rooms singleRoom = singleRooms.pop();
	        			  singleRoom.setAvailability(false);
	        			  bookedRooms.add(singleRoom);
	        		   }
	        		   else
	        		   {
	        			   reservation = new Reservations(reservationID,customerName,roomType);
	        			   singleWaitingLine.enqueue(reservation);
	        		   }
	        		   break;
	        	   case "Double":
	        		   if(!doubleRooms.isEmpty())
	        		   {
	        			   Rooms doubleRoom = doubleRooms.pop();
	        			   doubleRoom.setAvailability(false);
	        			   bookedRooms.add(doubleRoom);
	        		   }
	        		   else
	        		   {
	        			   reservation = new Reservations(reservationID,customerName,roomType);
	        			   doubleWaitingLine.enqueue(reservation);
	        		   }
	        		   break;
	        	   case "Suite":
	        		   if(!suiteRooms.isEmpty())
	        		   {
	        			   Rooms suiteRoom = suiteRooms.pop();
	        			   suiteRoom.setAvailability(false);
	        			   bookedRooms.add(suiteRoom);
	        		   }
	        		   else
	        		   {
	        			   reservation = new Reservations(reservationID,customerName,roomType);
	        			   suiteWaitingLine.enqueue(reservation);
	        		   }
	        		   break;
	        	   case "Deluxe":
	        		   if(!deluxeRooms.isEmpty())
	        		   {
	        			   Rooms deluxeRoom = deluxeRooms.pop();
	        			   deluxeRoom.setAvailability(false);
	        			   bookedRooms.add(deluxeRoom);
	        		   }
	        		   else
	        		   {
	        			   reservation = new Reservations(reservationID,customerName,roomType);
	        			   deluxeWaitingLine.enqueue(reservation);
	        		   }
	        		   break;
	        		default:
	        			System.out.println("Invalid Room Type: " + roomType);
	        			break;
	        	   }
	           }
		 } catch (IOException e) {
	           e.printStackTrace();
	       }

	}
	
	public static void makeOddNumberAvailable() throws EmptyListException
	{
		 
		 for(int i = 0 ; i<bookedRooms.getNumberOfElements()-1;i++)
		 {
			 Rooms room = bookedRooms.getEntry(i);
			 if(room.getRoomNumber()%2!=0)
			 {
				 room.setAvailability(true);
				 bookedRooms.remove(i);
				 i = i-1;
				 switch(room.getRoomType())
				 {
				 case "Single":
					 singleRooms.push(room);
					 break;
				 case "Double":
					 doubleRooms.push(room);
					 break;
				 case "Suite":
					 suiteRooms.push(room);
					 break;
				 case "Deluxe":
					 deluxeRooms.push(room);
					 break;
				 default:
					 System.out.println("Invalid Room Type: " + room.getRoomType());
					 break;
				 }
				 
			 }
		 }
	}
	
	
	public static void createAvailableAndUnavailableList() throws EmptyListException
	{
		 
		 while(!bookedRooms.isEmpty())
		 {
			 unavailableRooms.add(bookedRooms.remove(0));
		 }
		 
		 
		 
		 while(!singleRooms.isEmpty())
		 {
			 availableRooms.add(singleRooms.pop());
		 }
		 while(!doubleRooms.isEmpty())
		 {
			 availableRooms.add(doubleRooms.pop());
		 }
		 
		 while(!suiteRooms.isEmpty())
		 {
			 availableRooms.add(suiteRooms.pop());
		 }
		 
		 while(!deluxeRooms.isEmpty())
		 {
			 availableRooms.add(deluxeRooms.pop());
		 }
	}
	
	public static void reserve() throws EmptyQueueException
	{
		while(!singleRooms.isEmpty() && !singleWaitingLine.isEmpty())
		{
			singleWaitingLine.dequeue();
			Rooms room = singleRooms.pop();
			room.setAvailability(false);
			bookedRooms.add(room); 
		}
		while(!doubleRooms.isEmpty() && !doubleWaitingLine.isEmpty())
		{
			doubleWaitingLine.dequeue();
			Rooms room = doubleRooms.pop();
			room.setAvailability(false);
			bookedRooms.add(room); 
		}
		
		while(!suiteRooms.isEmpty() && !suiteWaitingLine.isEmpty())
		{
			suiteWaitingLine.dequeue();
			Rooms room = suiteRooms.pop();
			room.setAvailability(false);
			bookedRooms.add(room); 
		}
		
		while(!deluxeRooms.isEmpty() && !deluxeWaitingLine.isEmpty())
		{
			suiteWaitingLine.dequeue();
			Rooms room = deluxeRooms.pop();
			room.setAvailability(false);
			bookedRooms.add(room); 
		}
		
	}
	
	
	public static void main(String[] args) throws EmptyListException, EmptyQueueException {

		 createPileOfRooms();
		 
		 System.out.println("BEFORE PROCESSING THE RESERVATIONS THE PILE OF ROOMS :");
		 singleRooms.display();
		 doubleRooms.display();
		 suiteRooms.display();
		 deluxeRooms.display();
		
		 readFile();

		 
		 System.out.println("AFTER READING AND PROCESSING RESERVATIONS.TXT");
		 singleWaitingLine.display();
		 doubleWaitingLine.display();
		 suiteWaitingLine.display();
		 deluxeWaitingLine.display();
		 

		 
		 makeOddNumberAvailable();
		 

		 
		 sortForList(singleRooms);
		 sortForList(doubleRooms);
		 sortForList(suiteRooms);
		 sortForList(deluxeRooms);
		 
		 
		 System.out.println("AFTER ALL BOOKED ODD NUMBERED ROOMS AVAILABLE THE PILE OF ROOMS BEFORE PROCESSING RESERVATION:");
		 singleRooms.display();
		 doubleRooms.display();
		 suiteRooms.display();
		 deluxeRooms.display();
		 

		 
		 reserve();
		 
		 System.out.println("SITUATION AFTER PROCESSING WAITING LINE FOR ALL BOOKED ODD NUMBERED ROOMS AVAILABLE: ");
		 singleWaitingLine.display();
		 doubleWaitingLine.display();
		 suiteWaitingLine.display();
		 deluxeWaitingLine.display();
		 

		 		 
		 createAvailableAndUnavailableList();
			 
		 System.out.println("UNAVAILABLE ROOMS: ");
		 
		 unavailableRooms.display();
		  
		 System.out.println("AVAILABLE ROOMS: ");
		 
		 availableRooms.display();
		 

		 
		 
		 
		 
	}

}
