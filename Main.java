import java.util.Scanner;

class Room{
    int roomNumber;
    String category;
    boolean isAvailable;
    double price;

    public Room(int roomNumber, String category, boolean isAvailable, double price) {
        this.roomNumber  = roomNumber;
        this.category    = category;
        this.isAvailable = isAvailable;
        this.price       = price;
    }

    public String getDetails() {
        return "Room "+roomNumber+" ("+category+") - "+price+"rs -"+(isAvailable ? "Available":"Booked");
    }


}
class Booking
{
    int bookingId;
    String guestName;
    Room room;
    double amountPaid;

    public Booking(int bookingId, String guestName, Room room, double amountPaid) {
        this.bookingId  = bookingId;
        this.guestName  = guestName;
        this.room       = room;
        this.amountPaid = amountPaid;
    }
    public String getDetails(){
        return "Booking ID: "+bookingId+"\nGuest: "+guestName+"\nRoom: "+room.roomNumber+" ("+room.category+")\nAmount Paid: "+amountPaid+" rs";
    }
}








public class Main {


    public static void main(String[] args) {
         Room[] rooms=new Room[7];
         Booking[] bookings=new Booking[100];
         int bookingCounter=1;
        int bookingIndex=0;
        Scanner scanner = new Scanner(System.in);
 rooms[0] =new Room(101,"single",true,50000);
 rooms[1] =new Room(102,"double",true,500000);
 rooms[2] =new Room(103,"suite",true,1000000);
 rooms[3] =new Room(104,"single",true,50000);
 rooms[4] =new Room(105,"double",true,500000);
 rooms[5] =new Room(106,"single",true,50000);
 rooms[6] =new Room(107,"suite",true,1000000);
 while(true){
     System.out.println("\n--- Hotel Reservation System ---");
     System.out.println("1. View Available Rooms");
     System.out.println("2. Make a Reservation");
     System.out.println("3. View Bookings");
     System.out.println("4. Exit");
     System.out.print("Choose an option: ");
     int choice = scanner.nextInt();
     if(choice==1){
         System.out.println("\nAvailable Rooms: ");
         for(Room room:rooms){
             if(room.isAvailable){
                 System.out.println(room.getDetails());
             }
         }
     } else if (choice==2) {
         System.out.println("\nEnter your name");
         scanner.nextLine();
         String guestName=scanner.nextLine();
         System.out.println("\nAvailable Rooms: ");
         for(Room room:rooms){
             if(room.isAvailable){
                 System.out.println(room.getDetails());
             }
         }
         System.out.print("\nEnter the room number to book: ");
         int roomNumber = scanner.nextInt();

         Room selectedRoom = null;
         for (Room room : rooms) {
             if (room.roomNumber == roomNumber && room.isAvailable) {
                 selectedRoom = room;
                 break;
             }
         }

         if (selectedRoom == null) {
             System.out.println("Invalid room number or room is already booked. Try again.");
             continue;
         }

         System.out.println("\nThe price for the room is " + selectedRoom.price + "rs. Please enter payment amount: ");
         double payment = scanner.nextDouble();

         if (payment < selectedRoom.price) {
             System.out.println("Insufficient payment. Booking failed.");
             continue;
         }

         selectedRoom.isAvailable = false;
         bookings[bookingIndex++] = new Booking(bookingCounter++, guestName, selectedRoom, payment);

         System.out.println("Booking successful! Your booking details:");
         System.out.println(bookings[bookingIndex - 1].getDetails());
     } else if (choice == 3) {
         System.out.println("\nAll Bookings: ");
         if(bookingIndex==0){
             System.out.println("No bookings available");
         }
         else {
             for (int i = 0; i < bookingIndex; i++) {
                 System.out.println(bookings[i].getDetails());
                 System.out.println("-------------------");
             }

     }


 } else if (choice==4) {
         System.out.println("Goodbye...");
         break;
     }
     else{
         System.out.println("Invalid option. Please try again.");
     }

 }
 scanner.close();
} }