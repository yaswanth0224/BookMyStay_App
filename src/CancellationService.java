import java.util.*;

public class CancellationService {

    private Map<String, String> reservationRoomTypeMap;
    private Stack<String> rollbackHistory;

    public CancellationService() {
        reservationRoomTypeMap = new HashMap<>();
        rollbackHistory = new Stack<>();
    }

    public void registerBooking(String reservationId, String roomType) {

        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Reservation does not exist.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        Map<String, Integer> availability = inventory.getRoomAvailability();

        availability.put(roomType, availability.get(roomType) + 1);

        rollbackHistory.push(reservationId);

        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    public void showRollbackHistory() {

        System.out.println("\nRollback History (Most Recent First):");

        for (int i = rollbackHistory.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + rollbackHistory.get(i));
        }
    }
}