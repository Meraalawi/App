import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Truck extends Vehicle  implements Serializable {
    private static final long serialVersionUID = 1L;
    private double freeWeight;
    private double fullWeight;
    private static final ArrayList<Truck> truckList = new ArrayList<>();

    public Truck(String _plateNumber, String _serialNumber, Color _color, String _manufacturer, Date _manufactureDate,
    GearType _gearType, double _length, Engine _engine, double _fullWeight, double _freeWeight, double _width) {
        this.engine = _engine;
        this.fullWeight = _fullWeight;
        this.freeWeight = _freeWeight;
        this.plateNumber=_plateNumber;
        this.serialNumber=_serialNumber;
        this.manufacture=_manufacturer;
        this.manufactureDate=_manufactureDate;
        this.gearType=_gearType;
        this.width=_width;
        this.length=_length;
        this.color=_color;

    }
    static Scanner scanner = new Scanner(System.in);
    
    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public double getFreeWeight() {
        return this.freeWeight;
    }

    public void setFreeWeight(double freeWeight) {
        this.freeWeight = freeWeight;
    }

    public double getFullWeight() {
        return this.fullWeight;
    }

    public void setFullWeight(double fullWeight) {
        this.fullWeight = fullWeight;
    }
    
    public static double getValidWeight(String prompt) {
        double weight;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
                System.out.print(prompt);
            }
            weight = scanner.nextDouble();
            if (weight <= 0) {
                System.out.println("Weight must be a positive number. Please enter again.");
            }
        } while (weight <= 0);
        return weight;
    }
        

    public void print() {
        System.out.println("Truck Details:");
        System.out.println("Width: " + getWidth());
        System.out.println("Length: " + getLength());
        System.out.println("Color: " + getColor());
        System.out.println("Free Weight: " + freeWeight);
        System.out.println("Full Weight: " + fullWeight);
        System.out.println("Plate Number: " + getPlateNumber());
        System.out.println("Serial Number: " + getSerialNumber());
        System.out.println("Manufacturer: " + getManufacture());
        System.out.println("Manufacture Date: " + getManufactureDate());
        System.out.println("Gear Type: " + getGearType());
        System.out.println("Engine: ");
        engine.print();    
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        try {
            out.defaultWriteObject(); // Serializes non-transient fields
            out.writeObject(color);
            out.writeDouble(length);
            out.writeDouble(width);
            out.writeDouble(freeWeight);
            out.writeDouble(fullWeight);
            out.writeObject(serialNumber);
            out.writeObject(plateNumber);
            out.writeObject(manufacture);
            out.writeObject(manufactureDate);
            out.writeObject(gearType.toString());
            out.writeObject(engine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        try {
            in.defaultReadObject(); // Deserializes non-transient fields
            color = (Color) in.readObject();
            length = in.readDouble();
            width = in.readDouble();
            freeWeight = in.readDouble();
            fullWeight = in.readDouble();
            serialNumber = (String) in.readObject();
            plateNumber = (String) in.readObject();
            manufacture = (String) in.readObject();
            manufactureDate = (Date) in.readObject();
            gearType = GearType.valueOf((String) in.readObject());
            engine = (Engine) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void saveTruckArrayList() {
        String filename = "C:/Users/harriharri/Desktop/App/truck_data.txt"; // Adjust path as needed
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(truckList);
            objectOutputStream.flush();
            System.out.println("Truck data saved successfully.");

        } catch (IOException exception) {
            System.out.println("Error saving truck data: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadTruckArrayList() {
        String filename = "C:/Users/harriharri/Desktop/App/truck_data.txt"; // Adjust path as needed
        try (FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            truckList.clear(); // Clear current list before loading
            truckList.addAll((ArrayList<Truck>) objectInputStream.readObject());
            System.out.println("Truck data loaded successfully.");

        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Error loading truck data: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    public static ArrayList<Truck> getTruckList() {
        return truckList;
    }
}


