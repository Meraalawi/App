import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class VehicleManager  {
    private final Map<Integer, Object> automobileMap = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public VehicleManager() {
        automobileMap.put(1, new ArrayList<Car>());
        automobileMap.put(2, new ArrayList<Truck>());
        automobileMap.put(3, new ArrayList<Motorcycle>());
    }

    public void start() {
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

    private void performOperations(int listChoice) {
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
    public void addVehicle(int listChoice) {
        System.out.println("Adding a new vehicle...");
        Engine engine = addEngineDetails();
        String plateNumber = getPlateNumber();
        String serialNumber = getSerialNumber();
        Color color = Color.getColorFromInput();
        String manufacturer = getManufacturer();
        Date manufactureDate = getDateInput("Enter manufacture date (yyyy-MM-dd): ");
        GearType gearType = GearType.getGearTypeFromInput();
        double length = getLength();

            switch (listChoice) {
            case 1 -> {
                int chairNumber = getChairNumber();
                boolean isFurnitureLeather = parseBooleanInput();
                double width = getWidth();
                Car newCar = new Car(plateNumber, serialNumber, color, manufacturer, manufactureDate, gearType, length, engine, chairNumber, isFurnitureLeather, width);
                ((ArrayList<Car>) automobileMap.get(listChoice)).add(newCar);
                System.out.println("Car added successfully.");
            }

            case 2 -> {
                double fullWeight = Truck.getValidWeight("Enter full Weight capacity: ");
                double freeWeight = Truck.getValidWeight("Enter free Weight capacity: ");
                double width = getWidth();
                Truck newTruck = new Truck(plateNumber, serialNumber, color, manufacturer, manufactureDate, gearType, length, engine, fullWeight, freeWeight, width);
                ((ArrayList<Truck>) (automobileMap.get(listChoice))).add(newTruck);
                System.out.println("Truck added successfully.");
            }
            case 3 -> {
                double tireDiameter = Motorcycle.getValidTireDiameter();
                Motorcycle newMotorcycle = new Motorcycle(plateNumber, serialNumber, color, manufacturer, manufactureDate, gearType, length, engine, tireDiameter);
                ((ArrayList<Motorcycle>) automobileMap.get(listChoice)).add(newMotorcycle);
                System.out.println("Motorcycle added successfully.");
            }
            default -> System.out.println("Invalid vehicle type..try again");
        }
    }

    @SuppressWarnings("unchecked")
    public void searchVehicle(int listChoice) {
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
    }

    @SuppressWarnings("unchecked")
    public void deleteVehicle(int listChoice) {
        System.out.print("Enter the plate number or serial number of the vehicle you want to delete: ");
        String searchTerm = scanner.next();

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

    public void modifyVehicle(int listChoice) {
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

    private void modifyCar(Car car) {
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
            case 1 -> car.setPlateNumber(getPlateNumber());
            case 2 -> car.setSerialNumber(getSerialNumber());
            case 3 -> car.setColor(Color.getColorFromInput());
            case 4 -> car.setManufacture(getManufacturer());
            case 5 -> car.setManufactureDate(getDateInput("Enter manufacture date (yyyy-MM-dd): "));
            case 6 -> car.setGearType(GearType.getGearTypeFromInput());
            case 7 -> car.setLength(getLength());
            case 8 -> car.setEngine(addEngineDetails());
            case 9 -> car.setChairNumber(getChairNumber());
            case 10 -> car.setIsFurnitureLeather(parseBooleanInput());
            case 11 -> car.setWidth(getWidth());
            default -> System.out.println("Invalid choice.");
        }
    }

    private void modifyTruck(Truck truck) {
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
            case 1 -> truck.setPlateNumber(getPlateNumber());
            case 2 -> truck.setSerialNumber(getSerialNumber());
            case 3 -> truck.setColor(Color.getColorFromInput());
            case 4 -> truck.setManufacture(getManufacturer());
            case 5 -> truck.setManufactureDate(getDateInput("Enter manufacture date (yyyy-MM-dd): "));
            case 6 -> truck.setGearType(GearType.getGearTypeFromInput());
            case 7 -> truck.setLength(getLength());
            case 8 -> truck.setEngine(addEngineDetails());
            case 9 -> truck.setFullWeight(Truck.getValidWeight("Enter full Weight capacity: "));
            case 10 -> truck.setFreeWeight(Truck.getValidWeight("Enter free Weight capacity: "));
            case 11 -> truck.setWidth(getWidth());
            default -> System.out.println("Invalid choice.");
        }
    }

    private void modifyMotorcycle(Motorcycle motorcycle) {
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
            case 1 -> motorcycle.setPlateNumber(getPlateNumber());
            case 2 -> motorcycle.setSerialNumber(getSerialNumber());
            case 3 -> motorcycle.setColor(Color.getColorFromInput());
            case 4 -> motorcycle.setManufacture(getManufacturer());
            case 5 -> motorcycle.setManufactureDate(getDateInput("Enter manufacture date (yyyy-MM-dd): "));
            case 6 -> motorcycle.setGearType(GearType.getGearTypeFromInput());
            case 7 -> motorcycle.setLength(getLength());
            case 8 -> motorcycle.setEngine(addEngineDetails());
            case 9 -> motorcycle.setTireDiameter(Motorcycle.getValidTireDiameter());
            default -> System.out.println("Invalid choice.");
        }
    }

    public Engine addEngineDetails() {
        System.out.println("Enter engine details:");
        String manufacture = getManufacturer();
        Date manufactureDate = getDateInput("Enter engine manufacture date (yyyy-MM-dd): ");
        String model = Engine.getEngineModel();
        int capacity = Engine.getEngineCapacity();
        int cylinder = Engine.getEngineCylinderCount();
        FuelType fuelType = FuelType.getFuelTypeFromInput();
        return new Engine(manufacture, manufactureDate, model, capacity, cylinder, fuelType);
    }
    public  String getPlateNumber() {
        String plateNumber;
        do {
            System.out.print("Enter plate number (first letter + digits): ");
            plateNumber = scanner.next();
        } while (!plateNumber.matches("^[A-Za-z]\\d{1,7}$"));
        return plateNumber;
    }

    public  String getSerialNumber() {
        String serialNumber;
        do {
            System.out.print("Enter serial number (6 or more characters): ");
            serialNumber = scanner.next();
        } while (!serialNumber.matches("^[A-Za-z0-9]{6,20}$"));
        return serialNumber;
    }
    public double getWidth() {
        double width = 0.0;
        while (true) {
            System.out.print("Enter width: ");
            if (scanner.hasNextDouble()) {
                width = scanner.nextDouble();
                scanner.nextLine(); 
                break; 
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }
        return width;
    }
        public  int getChairNumber() {
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
                scanner.next(); 
            }
        return chairNumber;
    }    

    public  Date getDateInput(String promptMessage) {
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
public int getLength() {
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

public String getManufacturer() {
    String manufacturer;
    do {
        System.out.print("Enter manufacturer name (letters only, length 1-50): ");
        manufacturer = scanner.nextLine().trim();
    } while (!manufacturer.matches("^[a-zA-Z ]{1,50}$"));
    return manufacturer;
}


public boolean parseBooleanInput() {
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
}

