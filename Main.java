import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Car> cars = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();
        List<Motorcycle> motorcycles = new ArrayList<>();

       Map<Integer, List<? extends Automobile>> automobileMap = new HashMap<>();
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

            
        }
        List<? extends Automobile> selectedList = automobileMap.get(listChoice);

            if (selectedList == null) {
                System.out.println("Invalid choice.");
            } else {
                performOperations(selectedList);
            }
        }
    
    }


    private static void performOperations( List<T> selectedList, int listChoice) {
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
                    addVehicle(selectedList);
                    break;
                case 2:
                    searchVehicle(selectedList);
                    break;
                case 3:
                    deleteVehicle(selectedList);
                    break;
                case 4:
                    modifyVehicle(selectedList);
                    break;
                case 5:
                    return;
                case 6:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
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

    private static void addVehicle(selectedList) {
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
        
        if (selectedList.get instanceof Car) {
            System.out.print("Enter chair number: ");
            int chairNumber = scanner.nextInt();
            System.out.print("Is furniture leather? (true/false): ");
            boolean isFurnitureLeather = scanner.nextBoolean();
            Car newCar = new Car(plateNumber, serialNumber, color, manufacturer, manufactureDate, fuelType, gearType, width, length, chairNumber, isFurnitureLeather);
            ((List<Car>) selectedList).add(newCar);
            System.out.println("Car added successfully.");
        
    }
}   
            


