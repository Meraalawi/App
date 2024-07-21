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
                case 1 -> addVehicle(listChoice);
                case 2 -> searchVehicle(listChoice);
                case 3 -> deleteVehicle(listChoice);
                case 4 -> modifyVehicle(listChoice);
                case 5 -> {
                    return; // Go back to choose another list
                }
                case 6 -> {
                    System.out.println("Exiting program.");
                    System.exit(0);
                }
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
        String manufacturer = getManufacturer();
        Date manufactureDate = getDateInput("Enter manufacture date (yyyy-MM-dd): ");
        GearType gearType = GearType.getGearTypeFromInput();
        double length = getLength();
        double width = getWidth(listChoice);
        switch (listChoice) {
            case 1 -> {
                int chairNumber = getChairNumber();
                System.out.print("Is furniture leather? (true/false): ");
                boolean isFurnitureLeather = parseBooleanInput();
                Car newCar = new Car(plateNumber, serialNumber, color, manufacturer, manufactureDate, gearType, length, engine, chairNumber, isFurnitureLeather, width);
                ((ArrayList<Car>) automobileMap.get(listChoice)).add(newCar);
                System.out.println("Car added successfully.");
            }
        
            case 2 -> {
                double fullWeight = Truck.getValidWeight("Enter full Weight capacity: ");
                double freeWeight = Truck.getValidWeight("Enter free Weight capacity: ");
                Truck newTruck = new Truck(plateNumber, serialNumber, color, manufacturer, manufactureDate, gearType, length, engine, fullWeight, freeWeight, width);
                ((ArrayList<Truck>) (automobileMap.get(listChoice))).add(newTruck);
                System.out.println("Truck added successfully.");
            }
            case 3 -> {
                double tireDiameter =  Motorcycle.getValidTireDiameter();
                Motorcycle newMotorcycle = new Motorcycle(plateNumber, serialNumber, color, manufacturer, manufactureDate, gearType, length, engine, tireDiameter);
                ((ArrayList<Motorcycle>) automobileMap.get(listChoice)).add(newMotorcycle);
                System.out.println("Motorcycle added successfully.");
            }
            default -> System.out.println("Invalid vehicle type..try again");
        }
    }
    private static boolean parseBooleanInput() {
        String input;
        while (true) {
            System.out.print("Is furniture leather? (t/f): ");
            input = scanner.next().trim().toLowerCase();
            switch (input) {
                case "t" -> {
                    return true;
                }
                case "f" -> {
                    return false;
                }
                default -> System.out.println("Invalid input. Please enter 't' for true or 'f' for false.");
            }
        }
    }
    private static Engine addEngineDetails() {
        System.out.println("Enter engine details:");
        String manufacture = getManufacturer();
        Date manufactureDate = getDateInput("Enter engine manufacture date (yyyy-MM-dd): ");
        String model = Engine.getEngineModel();
        int capacity = Engine.getEngineCapacity();
        int cylinder =Engine.getEngineCylinderCount();
        FuelType fuelType = FuelType.getFuelTypeFromInput();
        Engine engine = new Engine(manufacture,manufactureDate,model,capacity,cylinder,fuelType);
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
                if (vehicle instanceof Car && listChoice == 1) {
                    ((Car) vehicle).print();
                } else if (vehicle instanceof Truck && listChoice == 2) {
                    ((Truck) vehicle).print();
                } else if (vehicle instanceof Motorcycle && listChoice == 3) {
                    ((Motorcycle) vehicle).print();
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
        System.out.println("11. Modify width");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                String plateNumber = getPlateNumber();
                car.setPlateNumber(plateNumber);
                break;
                case 2:
                String serialNumber = getSerialNumber();
                car.setSerialNumber(serialNumber);
                break;
            case 3:
                Color color = Color.getColorFromInput();
                car.setColor(color);
                break;
            case 4:
                String manufacturer = getManufacturer();
                car.setManufacture(manufacturer);
                break;
            case 5:
                Date manufactureDate = getDateInput("Enter new manufacture date (yyyy-MM-dd): ");
                car.setManufactureDate(manufactureDate);
                break;
            case 6:
                GearType gearType = GearType.getGearTypeFromInput();
                car.setGearType(gearType);
                break;
            case 7:
                double length = getLength();
                car.setLength(length);
                break;
            case 8:
                modifyEngine(car.getEngine());
                break;
            case 9:
                int chairNumber = getChairNumber();
                car.setChairNumber(chairNumber);
                break;
            case 10:
                boolean isFurnitureLeather = parseBooleanInput();
                car.setIsFurnitureLeather(isFurnitureLeather);
                case 11:
                System.out.print("Enter new width: ");
                double width = scanner.nextDouble();
                car.setWidth(width);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    System.out.println("Modification completed successfully.");

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
        System.out.println("11. Modify width");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
            case 1 -> {
                String plateNumber = getPlateNumber();
                truck.setPlateNumber(plateNumber);
            }
            case 2 -> {
                String serialNumber = getSerialNumber();
                truck.setSerialNumber(serialNumber);
            }
            case 3 -> {
                Color color = Color.getColorFromInput();
                truck.setColor(color);
            }
            case 4 -> {
                String manufacturer = getManufacturer();
                truck.setManufacture(manufacturer);
            }
            case 5 -> {
                Date manufactureDate = getDateInput("Enter new manufacture date (yyyy-MM-dd): ");
                truck.setManufactureDate(manufactureDate);
            }
            case 6 -> {
                GearType gearType = GearType.getGearTypeFromInput();
                truck.setGearType(gearType);
            }
            case 7 -> {
                double length = getLength();
                truck.setLength(length);
            }
            case 8 -> modifyEngine(truck.getEngine());
            case 9 -> {
                double fullWeight = Truck.getValidWeight("Enter full Weight capacity: ");
                truck.setFullWeight(fullWeight);
            }
            case 10 -> {
                double freeWeight = Truck.getValidWeight("Enter free Weight capacity: ");
                truck.setFreeWeight(freeWeight);
            }
            case 11 -> {
                System.out.print("Enter new width: ");
                double width = scanner.nextDouble();
                truck.setWidth(width);
            }
            default -> System.out.println("Invalid choice.");
        }
        System.out.println("Modification completed successfully.");
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
        scanner.nextLine(); 
    
        switch (choice) {
            case 1 -> {
                String plateNumber = getPlateNumber();
                motorcycle.setPlateNumber(plateNumber);
            }
            case 2 -> {
                String serialNumber = getSerialNumber();
                motorcycle.setSerialNumber(serialNumber);
            }
            case 3 -> {
                Color color = Color.getColorFromInput();
                motorcycle.setColor(color);
            }
            case 4 -> {
                String manufacturer = getManufacturer();
                motorcycle.setManufacture(manufacturer);
            }
            case 5 -> {
                Date manufactureDate = getDateInput("Enter new manufacture date (yyyy-MM-dd): ");
                motorcycle.setManufactureDate(manufactureDate);
            }
            case 6 -> {
                GearType gearType = GearType.getGearTypeFromInput();
                motorcycle.setGearType(gearType);
            }
            case 7 -> {
                double length = getLength();
                motorcycle.setLength(length);
            }
            case 8 -> modifyEngine(motorcycle.getEngine());
            case 9 -> {
                double tireDiameter = Motorcycle.getValidTireDiameter();
                motorcycle.setTireDiameter(tireDiameter);
            }
            default -> System.out.println("Invalid choice.");
        }
        System.out.println("Modification completed successfully.");

    }       
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
            scanner.nextLine(); 
        
            switch (engineChoice) {
                case 1 -> {
                    String manufacturer = getManufacturer();
                    engine.setManufacture(manufacturer);
            }
                case 2 -> {
                    Date manufactureDate = getDateInput("Enter new engine manufacture date (yyyy-MM-dd): ");
                    engine.setManufactureDate(manufactureDate);
            }
                case 3 -> {
                    String model = Engine.getEngineModel();
                    engine.setModel(model);
            }
                case 4 -> {
                    int capacity = Engine.getEngineCapacity();
                    engine.setCapacity(capacity);
            }
                case 5 -> {
                    int cylinderCount = Engine.getEngineCylinderCount();
                    engine.setCylinder(cylinderCount);
            }
                case 6 -> {
                    FuelType fuelType = FuelType.getFuelTypeFromInput(); 
                    engine.setFuelType(fuelType);
            }
                default -> System.out.println("Invalid engine detail choice.");
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
        double width = 0.0;
        if (listChoice == 1 || listChoice == 2) {
            System.out.print("Enter width: ");
            if (scanner.hasNextDouble()) {
                width = scanner.nextDouble();
                scanner.nextLine(); 
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }
        return width;
    }
            
    private static int getChairNumber() {
        int chairNumber = 0;
        

        System.out.print("Enter chair number (between 2 and 9): ");
            if (scanner.hasNextInt()) {
                chairNumber = scanner.nextInt();
                if (chairNumber >= 2 && chairNumber <= 9) {
                } else {
                    System.out.println("Chair number must be between 2 and 9.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 2 and 9.");
                scanner.next(); // Clear invalid input
            }
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
private static int getLength() {
    int length;
    while (true) {
        System.out.print("Enter a valid length (1-31): "); 
        if (scanner.hasNextInt()) {
            length = scanner.nextInt();
            if (length >= 1 && length <= 31) { 
                return length;
            }
        } else {
            scanner.next(); 
        }
        System.out.println("Invalid number. Please enter a positive number between 1 and 31.");
    }
}
private static String getManufacturer() {
    String manufacturer;
    while (true) {
        System.out.print("Enter manufacturer name (letters only, length 1-50): ");
        manufacturer = scanner.nextLine().trim();
        if (manufacturer.matches("[a-zA-Z ]{1,50}")) { 
            return manufacturer;
        } else {
            System.out.println("Invalid input. Please enter a valid manufacturer name (letters only, length 1-50).");
        }
    }
}
}
