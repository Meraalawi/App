import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Motorcycle extends Automobile implements Serializable {
    private static final long serialVersionUID = 1L; 
    private double tireDiameter;
    private double length;
    private Color color; 
    private static final ArrayList<Motorcycle> motorcycleList = new ArrayList<>();


    public Motorcycle(String _plateNumber, String _serialNumber, Color _color, String _manufacturer, Date _manufactureDate,
        GearType _gearType, double _length, Engine _engine, double _tireDiameter) {
        this.engine = _engine;
        this.tireDiameter = _tireDiameter;
        this.plateNumber=_plateNumber;
        this.serialNumber=_serialNumber;
        this.manufacture=_manufacturer;
        this.manufactureDate=_manufactureDate;
        this.gearType=_gearType;
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

    public double getTireDiameter() {
        return tireDiameter;
    }

    public void setTireDiameter(double tireDiameter) {
        this.tireDiameter = tireDiameter;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public static double getValidTireDiameter() {
        double tireDiameter = -1; 
        boolean isValid = false;
        System.out.print("Enter tire Diameter: ");

        while (!isValid) {
            if (scanner.hasNextDouble()) {
                tireDiameter = scanner.nextDouble();
                if (tireDiameter > 0) {
                    isValid = true;
                } else {
                    System.out.println("Tire diameter must be a positive number. Please enter again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        }
        
        return tireDiameter;
    }
    
    public void print() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Motorcycle Details:");
        System.out.println("Manufacture: " + getManufacture());
        System.out.println("Manufacture Date: " + (sdf.format(getManufactureDate())));
        System.out.println("Plate Number: " + getPlateNumber());
        System.out.println("Serial Number: " + getSerialNumber());
        System.out.println("Gear Type: " + getGearType());
        System.out.println("tireDiameter: " + tireDiameter);
        System.out.println("Length: " + length);
        System.out.println("Engine: ");
        engine.print();
    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        try {
            out.defaultWriteObject();
            out.writeObject(color);
            out.writeDouble(length);
            out.writeDouble(tireDiameter);
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
            in.defaultReadObject();
            color = (Color) in.readObject();
            length = in.readDouble();
            tireDiameter = in.readDouble();
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
@SuppressWarnings("unchecked")
    public void loadMotorcycleArrayList() {
        String filename = "C:/Users/harriharri/Desktop/App/motorcycle_data.txt"; // Adjust path as needed
        try (FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            motorcycleList.clear(); // Clear current list before loading
            motorcycleList.addAll((ArrayList<Motorcycle>) objectInputStream.readObject());
            System.out.println("Motorcycle data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading motorcycle data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void saveMotorcycleArrayList() throws IOException {
        String filename = "C:/Users/harriharri/Desktop/App/motorcycle_data.txt"; // Adjust path as needed
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(motorcycleList);
            objectOutputStream.flush();
            System.out.println("Motorcycle data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving motorcycle data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<Motorcycle> getMotorcycleList() {
        return motorcycleList;
    }
}
