import java.util.Date;

public class Truck extends Vehicle {
    private double freeWeight;
    private double fullWeight;
    Engine engine;
    public Truck() {
        super(0.0, 0.0, null);
        this.freeWeight = 0.0;
        this.fullWeight = 0.0;
    }

    public Truck(String plateNumber, String serialNumber, Color color, String manufacturer, Date manufactureDate,
    GearType gearType, double length, Engine engine, double fullWeight, double freeWeight) {
        super(0.0, length, color); // Assuming width is 0.0 (not provided in input)
        setPlateNumber(plateNumber);
        setSerialNumber(serialNumber);
        setManufacture(manufacturer);
        setManufactureDate(manufactureDate);
        setGearType(gearType);
        this.engine = engine;
        this.fullWeight = fullWeight;
        this.freeWeight = freeWeight;
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
        if (engine != null) {
            System.out.println("Engine:");
            engine.print();
        } else {
            System.out.println("Engine details are not available.");
        }
    
    }
}
