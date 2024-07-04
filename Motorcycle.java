import java.text.SimpleDateFormat;
import java.util.Date;

public class Motorcycle extends Automobile {
    private double tireDiameter;
    private double length;
     Engine engine;

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
