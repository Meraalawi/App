import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class Truck extends Vehicle  implements Serializable {
    private static final long serialVersionUID = 1L;
    private double freeWeight;
    private double fullWeight;

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
}
