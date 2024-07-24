import java.text.SimpleDateFormat;
import java.util.Date;

public class Car extends Vehicle {
    private int chairNumber;
    private boolean isFurnitureLeather;
    private Engine engine;

    public Car(String _plateNumber, String _serialNumber, Color _color, String _manufacturer, Date _manufactureDate,
    GearType _gearType, double _length, Engine _engine, int _chairNumber, boolean _isFurnitureLeather, double _width) {
        super(_width, _length, _color);
        super.setPlateNumber(_plateNumber);
        super.setSerialNumber(_serialNumber);
        super.setManufacture(_manufacturer);
        super.setManufactureDate(_manufactureDate);
        super.setGearType(_gearType);
        this.engine = _engine;
        this.chairNumber = _chairNumber;
        this.isFurnitureLeather = _isFurnitureLeather;
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
        getEngine().print();
    }
}
