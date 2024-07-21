import java.util.Scanner;

enum FuelType {
    NOT_DEFINE,
    DIESEL,
    GASOLINE,
    ELECTRIC,
    HYBRID;

    public static FuelType getFuelTypeFromInput(Scanner scanner) {
        System.out.println("Enter fuel type:");
        for (int i = 1; i < FuelType.values().length; i++) {
            System.out.println(i + ": " + FuelType.values()[i]);
        }

        int choice;
        while (true) {
            System.out.print("Enter your choice (1-" + (FuelType.values().length - 1) + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice < FuelType.values().length) {
                    return FuelType.values()[choice];
                }
            } else {
                scanner.next(); // Clear invalid input
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }
}
