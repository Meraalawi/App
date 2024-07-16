import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum GearType {
    NOT_DEFINE,
    NORMAL,
    AUTOMATIC;
    private static final Scanner scanner = new Scanner(System.in);

    public static GearType getGearTypeFromInput() {
        Map<Integer, GearType> gearTypeMap = new HashMap<>();
        System.out.println("Enter fuel type:\n1: NOT_DEFINE\n2: Diesel\n3: Gasoline\n4: Electric\n5: Hybrid");
        gearTypeMap.put(1, GearType.NOT_DEFINE);
        gearTypeMap.put(2, GearType.NORMAL);
        gearTypeMap.put(3, GearType.AUTOMATIC);

        return gearTypeMap.get(getUserChoice(gearTypeMap.size()));
    }

    private static int getUserChoice(int numOptions) {
        int choice;
        do {
            System.out.print("Enter a number (1-" + numOptions + "): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number (1-" + numOptions + "): ");
                scanner.next(); 
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > numOptions);
        return choice;
    }
}

