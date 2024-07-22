import java.text.SimpleDateFormat;

public class Car extends Vehicle {
    private int chairNumber;
    private boolean isFurnitureLeather;
    private Engine engine;

    public Car(String plateNumber, String serialNumber, Color color, String manufacturer, java.util.Date manufactureDate,
    GearType gearType, double length, Engine engine, int chairNumber, boolean isFurnitureLeather, double width) {
    super(width, length, color);
    setPlateNumber(plateNumber);
    setSerialNumber(serialNumber);
    setManufacture(manufacturer);
    setManufactureDate(manufactureDate);
    setGearType(gearType);
    this.engine = engine;
    this.chairNumber = chairNumber;
    this.isFurnitureLeather = isFurnitureLeather;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }

    public boolean getIsFurnitureLeather() {
        return isFurnitureLeather;
    }

    public void setIsFurnitureLeather(boolean isFurnitureLeather) {
        this.isFurnitureLeather = isFurnitureLeather;
    }

    public void print() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Car Details:");
        System.out.println("Width: " + getWidth());
        System.out.println("Length: " + getLength());
        System.out.println("Color: " + getColor());
        System.out.println("Chair Number: " + chairNumber);
        System.out.println("Is Furniture Leather: " + isFurnitureLeather);
        System.out.println("Plate Number: " + getPlateNumber());
        System.out.println("Serial Number: " + getSerialNumber());
        System.out.println("Manufacturer: " + getManufacture());
        System.out.println("Manufacture Date: " + (sdf.format(getManufactureDate())));
        System.out.println("Gear Type: " + getGearType());
        System.out.println("Engine: ");
        getEngine().print();
    }
}
