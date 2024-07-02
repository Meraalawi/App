import java.text.SimpleDateFormat;
import java.util.Date;

public class Motorcycle extends Automobile {
    private double tireDiameter;
    private double length;

    public Motorcycle() {
        super(null, new Date(), null, null, null, null, null);
        this.tireDiameter = 0.0;
        this.length = 0.0;
    }

    public Motorcycle(double tireDiameter, double length, Engine engine, Color color, double width, String plateNumber,
            FuelType fuelType, GearType gearType, String serialNumber, String manufacture, Date manufactureDate) {
        super(manufacture, manufactureDate, engine, plateNumber, fuelType, gearType, serialNumber);
        this.tireDiameter = tireDiameter;
        this.length = length;
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
