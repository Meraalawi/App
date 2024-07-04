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
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
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
        System.out.print("Enter color (1: RED, 2: WHITE, 3: BLACK, 4: BLUE, 5: GREEN, 6: YELLOW): ");
        Color color = getColorFromInput();
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.next();
        Date manufactureDate;
        do {
            System.out.print("Enter manufacture date (YYYY-MM-DD): ");
            String dateStr = scanner.next();
            manufactureDate = parseDate(dateStr);
        } while (manufactureDate == null);
             System.out.print("Enter gear type (1: NOT_DEFINE, 2: NORMAL, 3: AUTOMATIC): ");
        GearType gearType = getGearTypeFromInput();
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();

        if (listChoice == 1 || listChoice == 2) {
            System.out.print("Enter width: ");
            double width = scanner.nextDouble();
        }

        Engine engine = addEngineDetails();

        switch (listChoice) {
            case 1:
                System.out.print("Enter chair number: ");
                int chairNumber = scanner.nextInt();
                System.out.print("Is furniture leather? (true/false): ");
                boolean isFurnitureLeather = parseBooleanInput(scanner.next());
                Car newCar = new Car(plateNumber, serialNumber, color, manufacturer, manufactureDate, gearType, length, engine, chairNumber, isFurnitureLeather);
                ((ArrayList<Car>) automobileMap.get(listChoice)).add(newCar);
                newCar.print();
                System.out.println("Car added successfully.");
                break;
            case 2:
                System.out.print("Enter full Weight capacity: ");
                double fullWeight = scanner.nextDouble();
                System.out.print("Enter free Weight capacity: ");
                double freeWeight = scanner.nextDouble();
                Truck newTruck = new Truck(plateNumber, serialNumber, color, manufacturer, manufactureDate, gearType, length, engine, fullWeight, freeWeight);
                ((ArrayList<Truck>) (automobileMap.get(listChoice))).add(newTruck);
                System.out.println("Truck added successfully.");
                break;
            case 3:
                System.out.print("Enter tire Diameter: ");
                double tireDiameter = scanner.nextDouble();
                Motorcycle newMotorcycle = new Motorcycle(plateNumber, serialNumber, color, manufacturer, manufactureDate, gearType, length, engine, tireDiameter);
                ((ArrayList<Motorcycle>) automobileMap.get(listChoice)).add(newMotorcycle);
                System.out.println("Motorcycle added successfully.");
                break;
            default:
                System.out.println("Invalid vehicle type.");
        }
    }
    private static boolean parseBooleanInput(String input) {
        return input.equalsIgnoreCase("t");
     }
     

     private static Engine addEngineDetails() {
        System.out.println("Enter engine details:");
     
     
        System.out.print("Enter engine manufacture: ");
        String manufacture = scanner.next();
     
     
        Date manufactureDate;
        do {
            System.out.print("Enter engine manufacture date (YYYY-MM-DD): ");
            String dateStr = scanner.next();
            manufactureDate = parseDate(dateStr);
        } while (manufactureDate == null);
     
     
        System.out.print("Enter engine model: ");
        String model = scanner.next();
     
     
        System.out.print("Enter engine capacity: ");
        int capacity = scanner.nextInt();
     
     
        System.out.print("Enter engine cylinder: ");
        int cylinder = scanner.nextInt();
     
     
        System.out.print("Enter feul type:  (1: NOT_DEFINE, 2: Diesel, 3: Gasoline ,4:Elctric ,5;Hybird):");
        FuelType fuelType = getFuelTypeFromInput();
     
     
        Engine engine = new Engine();
        engine.setManufacture(manufacture);
        engine.setManufactureDate(manufactureDate);
        engine.setModel(model);
        engine.setCapacity(capacity);
        engine.setCylinder(cylinder);
        engine.setFuelType(fuelType);
     
     
        return engine;
     }
     

    private static Color getColorFromInput() {
        Map<Integer, Color> colorMap = new HashMap<>();
        colorMap.put(1, Color.RED);
        colorMap.put(2, Color.WHITE);
        colorMap.put(3, Color.BLACK);
        colorMap.put(4, Color.BLUE);
        colorMap.put(5, Color.GREEN);
        colorMap.put(6, Color.YELLOW);

        return colorMap.get(getUserChoice(colorMap.size()));
    }

    private static FuelType getFuelTypeFromInput() {
        Map<Integer, FuelType> fuelTypeMap = new HashMap<>();
        fuelTypeMap.put(1, FuelType.NOT_DEFINE);
        fuelTypeMap.put(2, FuelType.DIESEL);
        fuelTypeMap.put(3, FuelType.GASOLINE);
        fuelTypeMap.put(4, FuelType.ELCTRIC);
        fuelTypeMap.put(5, FuelType.HYBIRD);

        return fuelTypeMap.get(getUserChoice(fuelTypeMap.size()));
    }

    private static GearType getGearTypeFromInput() {
        Map<Integer, GearType> gearTypeMap = new HashMap<>();
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

    private static void searchVehicle(int listChoice) {
        System.out.print("Enter the plate number or serial number of the vehicle you want to search: ");
    }

    private static void deleteVehicle(int listChoice) {
        System.out.println("This is the deleteVehicle method.");
    }

    private static void modifyVehicle(int listChoice) {
        System.out.println("This is the modifyVehicle method.");
    }
}
