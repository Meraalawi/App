import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Car extends Vehicle implements Serializable {
    private static final long serialVersionUID = 1L; // Unique identifier for serialization
    private int chairNumber;
    private boolean isFurnitureLeather;

    public Car(String _plateNumber, String _serialNumber, Color _color, String _manufacturer, Date _manufactureDate,
    GearType _gearType, double _length, Engine _engine, int _chairNumber, boolean _isFurnitureLeather, double _width) {
        this.engine = _engine;
        this.chairNumber = _chairNumber;
        this.isFurnitureLeather = _isFurnitureLeather;
        this.plateNumber=_plateNumber;
        this.serialNumber=_serialNumber;
        this.manufacture=_manufacturer;
        this.manufactureDate=_manufactureDate;
        this.gearType=_gearType;
        this.width=_width;
        this.length=_length;
        this.color=_color;

}
    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
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
        engine.print();
    }
}
