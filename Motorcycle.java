import java.util.Date;

public class Motorcycle extends Automobile {
    private double tireDiameter;
    private double length;

    public Motorcycle() {
        super(null, new Date(), null, 0, null, null, 0);
        this.tireDiameter = 0.0;
        this.length = 0.0;
    }

    public Motorcycle(double tireDiameter, double length, Engine engine, Color color, double width, int plateNumber, FuelType fuelType, GearType gearType, int serialNumber, String manufacture, Date manufactureDate) {
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
}
