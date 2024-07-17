import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
enum FuelType {
    NOT_DEFINE, 
    DIESEL,
    GASOLINE,
    HYBIRD,
    ELCTRIC;
    private static final Scanner scanner = new Scanner(System.in);

    public static FuelType getFuelTypeFromInput() {
        Map<Integer, FuelType> fuelTypeMap = new HashMap<>();
        System.out.println("Enter fuel type:\n1: NOT_DEFINE\n2: Diesel\n3: Gasoline\n4: Electric\n5: Hybrid");

        fuelTypeMap.put(1, FuelType.NOT_DEFINE);
        fuelTypeMap.put(2, FuelType.DIESEL);
        fuelTypeMap.put(3, FuelType.GASOLINE);
        fuelTypeMap.put(4, FuelType.ELCTRIC);
        fuelTypeMap.put(5, FuelType.HYBIRD);

        int choice = getUserChoice(fuelTypeMap.size());

        return fuelTypeMap.get(choice);
    }
    private static int getUserChoice(int numOptions) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Enter your choice (1-" + numOptions + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > numOptions);
        return choice;
    }
}