import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static Map<Integer, Object> automobileMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Truck> trucks = new ArrayList<>();
        ArrayList<Motorcycle> motorcycles = new ArrayList<>();

        automobileMap.put(1, cars);
        automobileMap.put(2, trucks);
        automobileMap.put(3, motorcycles);

        while (true) {
            System.out.println("Choose a list to work with:");
            System.out.println("1. Car list");
            System.out.println("2. Truck list");
            System.out.println("3. Motorcycle list");
            System.out.println("4. Exit");
            int listChoice = scanner.nextInt();
            scanner.nextLine();

            if (listChoice == 4) {
                System.out.println("Exiting program.");
                break;
            }
            if (!automobileMap.containsKey(listChoice)) {
                System.out.println("Invalid choice.");
            } else {
                performOperations(listChoice);
            }
        }
    }

    private static void performOperations(int listChoice) {
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
                    addVehicle(listChoice);
                    break;
                case 2:
                    searchVehicle(listChoice);
                    break;
                case 3:
                    deleteVehicle(listChoice);
                    break;
                case 4:
                    modifyVehicle(listChoice);
                    break;
                case 5:
                    return; // Go back to choose another list
                case 6:
                    System.out.println("Exiting program.");
                    System.exit(0);

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

    @SuppressWarnings("unchecked")
    private static void addVehicle(int listChoice) {
        System.out.println("Adding a new vehicle...");

        System.out.print("Enter plate number: ");
        String plateNumber = scanner.next();
        System.out.print("Enter serial number: ");
        String serialNumber = scanner.next();
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

        switch (listChoice) {
            case 1:
                System.out.print("Enter chair number: ");
                int chairNumber = scanner.nextInt();
                System.out.print("Is furniture leather? (true/false): ");
                boolean isFurnitureLeather = scanner.nextBoolean();
                Car newCar = new Car();
                ((ArrayList<Car>) automobileMap.get(listChoice)).add(newCar);
                System.out.println("Car added successfully.");
                break;
            case 2:
                System.out.print("Enter full Weight capacity: ");
                double fullWeight = scanner.nextDouble();
                System.out.print("Enter free Weight capacity: ");
                double freeWeight = scanner.nextDouble();
                Truck newTruck = new Truck();
                ((ArrayList<Truck>) (automobileMap.get(listChoice))).add(newTruck);
                System.out.println("Truck added successfully.");
                break;
            case 3:
                System.out.print("Enter tire Diameter: ");
                double tireDiameter = scanner.nextDouble();
                Motorcycle newMotorcycle = new Motorcycle();
                ((ArrayList<Motorcycle>) automobileMap.get(listChoice)).add(newMotorcycle);
                System.out.println("Motorcycle added successfully.");
                break;
            default:
                System.out.println("Invalid vehicle type.");
        }
    }

    private static void searchVehicle(int listChoice) {
        System.out.print("Enter the plate number or serial number of the veichle you want to search: ");
    }

    private static void deleteVehicle(int listChoice) {
        System.out.println("This is the deleteVehicle method.");
    }

    private static void modifyVehicle(int listChoice) {
        System.out.println("This is the modifyVehicle method.");
    }
}
