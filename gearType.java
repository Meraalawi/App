import java.util.Scanner;

enum GearType {
    NOT_DEFINE,
    NORMAL,
    AUTOMATIC;

    public static GearType getGearTypeFromInput(Scanner scanner) {
        System.out.println("Enter gear type:");
        for (int i = 1; i < GearType.values().length; i++) {
            System.out.println(i + ": " + GearType.values()[i]);
        }

        int choice;
        while (true) {
            System.out.print("Enter your choice (1-" + (GearType.values().length - 1) + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice < GearType.values().length) {
                    return GearType.values()[choice];
                }
            } else {
                scanner.next(); // Clear invalid input
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }
}
