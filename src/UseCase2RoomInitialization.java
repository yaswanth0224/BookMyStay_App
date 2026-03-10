public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("Hotel Room Types and Availability");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("\nSingle Room:");
        single.displayRoomDetails();

        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();
    }
}