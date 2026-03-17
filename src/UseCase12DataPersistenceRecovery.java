public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();

        FilePersistenceService persistenceService =
                new FilePersistenceService();

        String filePath = "inventory.txt";

        persistenceService.loadInventory(inventory, filePath);

        System.out.println("\nCurrent Inventory:");

        inventory.getRoomAvailability().forEach(
                (type, count) ->
                        System.out.println(type + ": " + count)
        );

        persistenceService.saveInventory(inventory, filePath);
    }
}