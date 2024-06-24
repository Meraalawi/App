import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();
        List<Motorcycle> motorcycles = new ArrayList<>();

        while (true) {
            System.out.println("Choose a list to work with:");
            System.out.println("1. Car list");
            System.out.println("2. Truck list");
            System.out.println("3. Motorcycle list");
            System.out.println("4. Exit");
            int listChoice = scanner.nextInt();

            switch (listChoice) {
                case 1:
                    performOperations(scanner, cars, listChoice);
                    break;
                case 2:
                    performOperations(scanner, trucks,listChoice);
                    break;
                case 3:
                    performOperations(scanner, motorcycles,listChoice);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }


    private static <T extends Automobile> void performOperations(Scanner scanner, List<T> selectedList, int listChoice) {
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add a new vehicle");
            System.out.println("2. Search for a vehicle");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Modify a vehicle");
            System.out.println("5. Go back to choose another list");
            System.out.println("6. Exit");
            int operationChoice = scanner.nextInt();
            scanner.nextLine();

            switch (operationChoice) {
                case 1:
                    addVehicle(scanner, selectedList,listChoice);
                    break;
            }
        }
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return null;
        }
    }

    private static <T extends Automobile> void addVehicle(Scanner scanner, List<T> selectedList,int listChoice) {
        System.out.println("Adding a new vehicle...");

        System.out.print("Enter plate number: ");
        int plateNumber = scanner.nextInt();
        System.out.print("Enter serial number: ");
        int serialNumbe = scanner.nextInt();
        System.out.print("Enter color (RED, WHITE, BLACK, BLUE, GREEN, YELLOW): ");
        Color color = Color.valueOf(scanner.next().toUpperCase());
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.next();
        System.out.print("Enter manufacture date (YYYY-MM-DD): ");
        String dateStr = scanner.next();
        Date manufactureDate = parseDate(dateStr);
        System.out.print("Enter fuel type (NOT_DEFINE, DIESEL, GASOLINE, ELECTRIC, HYBRID): ");
        FuelType fuelType = FuelType.valueOf(scanner.next().toUpperCase());
        System.out.print("Enter gear type (NOT_DEFINE, NORMAL, AUTOMATIC): ");
        GearType gearType = GearType.valueOf(scanner.next().toUpperCase());
        System.out.print("Enter width: ");
        double width = scanner.nextDouble();
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        
        if (listChoice == 1) {
            System.out.print("Enter chair number: ");
            int chairNumber = scanner.nextInt();
            System.out.print("Is furniture leather? (true/false): ");
            boolean isFurnitureLeather = scanner.nextBoolean();
            Car newCar = new Car(chairNumber, isFurnitureLeather, width, length, color);
            selectedList.add((T) newCar);
            System.out.println("Car added successfully.");
        }
    }
}   
            


