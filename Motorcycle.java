import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Motorcycle extends Automobile {
    private double tireDiameter;
    private double length;
    Engine engine;
    private Color color; // Add this if not present

    public Motorcycle() {
        super(null, new Date(), null, null, null, null, null);
        this.tireDiameter = 0.0;
        this.length = 0.0;
    }

    public Motorcycle(String plateNumber, String serialNumber, Color color, String manufacturer, Date manufactureDate,
        GearType gearType, double length, Engine engine, double tireDiameter) {
        super(manufacturer, manufactureDate, engine, plateNumber, null, gearType, serialNumber);
        this.length = length;
        this.engine = engine;
        this.tireDiameter = tireDiameter;
}
static Scanner scanner = new Scanner(System.in);

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
        getEngine().print();
    }
}
