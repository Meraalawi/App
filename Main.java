import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, Object> automobileMap = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

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

    @SuppressWarnings("unchecked")
    private static void addVehicle(int listChoice) {
        System.out.println("Adding a new vehicle...");
        Engine engine = addEngineDetails();

        String plateNumber = getPlateNumber();
        String serialNumber = getSerialNumber();
        Color color = Color.getColorFromInput();
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.next();
        Date manufactureDate = getDateInput("Enter manufacture date (yyyy-MM-dd): ");
        GearType gearType = GearType.getGearTypeFromInput();
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        double width = getWidth(listChoice);

        switch (listChoice) {
            case 1:
                int chairNumber = getChairNumber();
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
                System.out.println("Invalid vehicle type..try again");
        }
    }
    private static boolean parseBooleanInput(String input) {
        return input.equalsIgnoreCase("t");
    }

    private static Engine addEngineDetails() {
        System.out.println("Enter engine details:");
        System.out.print("Enter engine manufacture: ");
        String manufacture = scanner.next();
        Date manufactureDate = getDateInput("Enter engine manufacture date (yyyy-MM-dd): ");
        System.out.print("Enter engine model: ");
        String model = scanner.next();
        int capacity = Engine.getEngineCapacity();
        int cylinder =Engine.getEngineCylinderCount();
        FuelType fuelType = FuelType.getFuelTypeFromInput();
        Engine engine = new Engine();
        engine.setManufacture(manufacture);
        engine.setManufactureDate(manufactureDate);
        engine.setModel(model);
        engine.setCapacity(capacity);
        engine.setCylinder(cylinder);
        engine.setFuelType(fuelType);
        return engine;
    }

    @SuppressWarnings("unchecked")
    private static void searchVehicle(int listChoice) {
        System.out.print("Enter the plate number or serial number of the vehicle you want to search: ");
        String searchTerm = scanner.next();
        boolean found = false;
        ArrayList<? extends Automobile> vehicleList = (ArrayList<? extends Automobile>) automobileMap.get(listChoice);
            for (Automobile vehicle : vehicleList) {
            if (searchTerm.equalsIgnoreCase(vehicle.getPlateNumber()) || searchTerm.equalsIgnoreCase(vehicle.getSerialNumber())) {
                if (searchTerm.equalsIgnoreCase(vehicle.getPlateNumber())) {
                    System.out.println("Search based by plate number:");
                } else {
                    System.out.println("Search based by serial number:");
                }
                
                if (vehicle instanceof Car && listChoice == 1) {
                    ((Car) vehicle).print();
                } else if (vehicle instanceof Truck && listChoice == 2) {
                    ((Truck) vehicle).print();
                } else {
                    System.out.println("Invalid vehicle type.");
                }
    
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Vehicle not found.");
        }
    }
    
    private static void deleteVehicle(int listChoice) {
    System.out.print("Enter the plate number or serial number of the vehicle you want to delete: ");
    String searchTerm = scanner.next();
    
    @SuppressWarnings("unchecked")
    ArrayList<? extends Automobile> vehicleList = (ArrayList<? extends Automobile>) automobileMap.get(listChoice);
    boolean found = false;

    Iterator<? extends Automobile> iterator = vehicleList.iterator();
    while (iterator.hasNext()) {
        Automobile vehicle = iterator.next();
        if (searchTerm.equalsIgnoreCase(vehicle.getPlateNumber()) || searchTerm.equalsIgnoreCase(vehicle.getSerialNumber())) {
            if (searchTerm.equalsIgnoreCase(vehicle.getPlateNumber())) {
                System.out.println("Deleting vehicle based on plate number:");
            } else {
                System.out.println("Deleting vehicle based on serial number:");
            }
            
            iterator.remove(); 
            System.out.println("Vehicle deleted successfully.");
            found = true;
            break; 
        }
    }

    if (!found) {
        System.out.println("Vehicle not found.");
    }
}


    private static void modifyVehicle(int listChoice) {
        System.out.print("Enter the plate number or serial number of the vehicle you want to modify: ");
        String searchTerm = scanner.next();
    
        @SuppressWarnings("unchecked")
        ArrayList<? extends Automobile> vehicleList = (ArrayList<? extends Automobile>) automobileMap.get(listChoice);
        boolean found = false;
    
        for (Automobile vehicle : vehicleList) {
            if (searchTerm.equalsIgnoreCase(vehicle.getPlateNumber()) || searchTerm.equalsIgnoreCase(vehicle.getSerialNumber())) {
                if (searchTerm.equalsIgnoreCase(vehicle.getPlateNumber())) {
                    System.out.println("Modifying vehicle based on plate number:");
                } else {
                    System.out.println("Modifying vehicle based on serial number:");
                }
    
                if (vehicle instanceof Car && listChoice == 1) {
                    modifyCar((Car) vehicle);
                } else if (vehicle instanceof Truck && listChoice == 2) {
                    modifyTruck((Truck) vehicle);
                } else if (vehicle instanceof Motorcycle && listChoice == 3) {
                    modifyMotorcycle((Motorcycle) vehicle);
                } else {
                    System.out.println("Invalid vehicle type.");
                }
    
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Vehicle not found.");
        }
    }
    
    private static void modifyCar(Car car) {
        System.out.println("Modifying car:");
        System.out.println("1. Modify plate number");
        System.out.println("2. Modify serial number");
        System.out.println("3. Modify color");
        System.out.println("4. Modify manufacturer");
        System.out.println("5. Modify manufacture date");
        System.out.println("6. Modify gear type");
        System.out.println("7. Modify length");
        System.out.println("8. Modify engine details");
        System.out.println("9. Modify chair number");
        System.out.println("10. Modify is furniture leather");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                String plateNumber = getPlateNumber();
                System.out.println("Plate number modified successfully.");
                break;
            case 2:
                String serialNumber = getSerialNumber();
                System.out.println("Serial number modified successfully.");
                break;
            case 3:
                Color color = Color.getColorFromInput();
                System.out.println("Color modified successfully.");
                break;
            case 4:
                System.out.print("Enter new manufacturer: ");
                String manufacturer = scanner.next();
                System.out.println("Manufacturer modified successfully.");
                break;
            case 5:
                Date manufactureDate = getDateInput("Enter new manufacture date (yyyy-MM-dd): ");
                System.out.println("Manufacture date modified successfully.");
                break;
            case 6:
                GearType gearType = GearType.getGearTypeFromInput();
                System.out.println("Gear type modified successfully.");
                break;
            case 7:
                System.out.print("Enter new length: ");
                double length = scanner.nextDouble();
                System.out.println("Length modified successfully.");
                break;
            case 8:
                modifyEngine(car.getEngine());
                System.out.println("Engine details modified successfully.");
                break;
            case 9:
                int chairNumber = getChairNumber();
                System.out.println("Chair number modified successfully.");
                break;
            case 10:
                System.out.print("Enter new value for is furniture leather (true/false): ");
                boolean isFurnitureLeather = parseBooleanInput(scanner.next());
                System.out.println("Is furniture leather modified successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
    
    private static void modifyTruck(Truck truck) {
        System.out.println("Modifying truck:");
        System.out.println("1. Modify plate number");
        System.out.println("2. Modify serial number");
        System.out.println("3. Modify color");
        System.out.println("4. Modify manufacturer");
        System.out.println("5. Modify manufacture date");
        System.out.println("6. Modify gear type");
        System.out.println("7. Modify length");
        System.out.println("8. Modify engine details");
        System.out.println("9. Modify full weight capacity");
        System.out.println("10. Modify free weight capacity");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
    
        switch (choice) {
            case 1:
                String plateNumber = getPlateNumber();
                System.out.println("Plate number modified successfully.");
                break;
            case 2:
                String serialNumber = getSerialNumber();
                System.out.println("Serial number modified successfully.");
                break;
            case 3:
                Color color = Color.getColorFromInput();
                System.out.println("Color modified successfully.");
                break;
            case 4:
                System.out.print("Enter new manufacturer: ");
                String manufacturer = scanner.next();
                System.out.println("Manufacturer modified successfully.");
                break;
            case 5:
                Date manufactureDate = getDateInput("Enter new manufacture date (yyyy-MM-dd): ");
                System.out.println("Manufacture date modified successfully.");
                break;
            case 6:
                GearType gearType = GearType.getGearTypeFromInput();
                System.out.println("Gear type modified successfully.");
                break;
            case 7:
                System.out.print("Enter new length: ");
                double length = scanner.nextDouble();
                System.out.println("Length modified successfully.");
                break;
            case 8:
                modifyEngine(truck.getEngine());   
                System.out.println("Engine details modified successfully.");
                break;
            case 9:
                System.out.print("Enter new full weight capacity: ");
                double fullWeight = scanner.nextDouble();
                System.out.println("Full weight capacity modified successfully.");
                break;
            case 10:
                System.out.print("Enter new free weight capacity: ");
                double freeWeight = scanner.nextDouble();
                System.out.println("Free weight capacity modified successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
    
    private static void modifyMotorcycle(Motorcycle motorcycle) {
        System.out.println("Modifying motorcycle:");
        System.out.println("1. Modify plate number");
        System.out.println("2. Modify serial number");
        System.out.println("3. Modify color");
        System.out.println("4. Modify manufacturer");
        System.out.println("5. Modify manufacture date");
        System.out.println("6. Modify gear type");
        System.out.println("7. Modify length");
        System.out.println("8. Modify engine details");
        System.out.println("9. Modify tire diameter");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
    
        switch (choice) {
            case 1:
                String plateNumber = getPlateNumber();
                System.out.println("Plate number modified successfully.");
                break;
            case 2:
                String serialNumber = getSerialNumber();
                System.out.println("Serial number modified successfully.");
                break;
            case 3:
                Color color = Color.getColorFromInput();
                System.out.println("Color modified successfully.");
                break;
            case 4:
                System.out.print("Enter new manufacturer: ");
                String manufacturer = scanner.next();
                System.out.println("Manufacturer modified successfully.");
                break;
            case 5:
                Date manufactureDate = getDateInput("Enter new manufacture date (yyyy-MM-dd): ");
                System.out.println("Manufacture date modified successfully.");
                break;
            case 6:
                GearType gearType = GearType.getGearTypeFromInput();
                System.out.println("Gear type modified successfully.");
                break;
            case 7:
                System.out.print("Enter new length: ");
                double length = scanner.nextDouble();
                System.out.println("Length modified successfully.");
                break;
            case 8:
                modifyEngine(motorcycle.getEngine());   
                System.out.println("Engine details modified successfully.");
                break;
            case 9:
                System.out.print("Enter new tire diameter: ");
                double tireDiameter = scanner.nextDouble();
                System.out.println("Tire diameter modified successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }}
        private static void modifyEngine(Engine engine) {
            System.out.println("Modifying engine details:");
            System.out.println("1. Modify engine manufacturer");
            System.out.println("2. Modify engine manufacture date");
            System.out.println("3. Modify engine model");
            System.out.println("4. Modify engine capacity");
            System.out.println("5. Modify engine cylinder count");
            System.out.println("6. Modify engine fuel type");
            System.out.print("Enter your choice: ");
            int engineChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
        
            switch (engineChoice) {
                case 1:
                    System.out.print("Enter new engine manufacturer: ");
                    String manufacture = scanner.next();
                    break;
                case 2:
                    Date manufactureDate = getDateInput("Enter new engine manufacture date (yyyy-MM-dd): ");
                    break;
                case 3:
                    System.out.print("Enter new engine model: ");
                    String model = scanner.next();
                    break;
                case 4:
                    int capacity = Engine.getEngineCapacity();
                    break;
                case 5:
                    int cylinder = Engine.getEngineCylinderCount();
                    break;
                case 6:
                    FuelType fuelType = FuelType.getFuelTypeFromInput();
                    break;
                default:
                    System.out.println("Invalid engine detail choice.");
                    break;
            }
    }    
    private static String getPlateNumber() {
        String plateNumber;
        do {
            System.out.print("Enter plate number (first letter + up to 5 digits): ");
            plateNumber = scanner.next();
        } while (!plateNumber.matches("^[A-Za-z]\\d{1,5}$"));
        return plateNumber;
    }

    private static String getSerialNumber() {
        String serialNumber;
        do {
            System.out.print("Enter serial number (6 or more characters): ");
            serialNumber = scanner.next();
        } while (!serialNumber.matches("^[A-Za-z0-9]{6,20}$"));
        return serialNumber;
    }
    private static double getWidth(int listChoice) {
        double width;
        width = 0.0;
        if (listChoice == 1 || listChoice == 2) {
            System.out.print("Enter width: ");
            width = scanner.nextDouble();
        }
        return width;
    }
    private static int getChairNumber() {
        String regex = "[2-9]"; // 2 min and 9 max
        int chairNumber;
        do {
            System.out.print("Enter chair number: ");
            String input = scanner.nextLine().trim();
            if (input.matches(regex)) {
                chairNumber = Integer.parseInt(input);
                break;
                }
        } while (true);
        return chairNumber;
    }

private static Date getDateInput(String promptMessage) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    Date parsedDate = null;

    while (parsedDate == null) {
        try {
            System.out.print(promptMessage);
            String dateStr = scanner.next();
            parsedDate = dateFormat.parse(dateStr);

            // Validate that the date is 1950 or later
            Date minDate = dateFormat.parse("1950-01-01");
            if (parsedDate.compareTo(minDate) < 0) {
                System.out.println("Manufacture date must be 1950 or later.");
                parsedDate = null;
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }

        if (parsedDate == null) {
            System.out.print("Enter manufacture date (yyyy-MM-dd): ");
        }
    }

    return parsedDate;
}
}