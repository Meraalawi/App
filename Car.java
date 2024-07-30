
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Car extends Vehicle implements Serializable {

    private static final long serialVersionUID = 1L; // Unique identifier for serialization
    private int chairNumber;
    private boolean isFurnitureLeather;
    private static final ArrayList<Car> carList = new ArrayList<>();

    public Car(String _plateNumber, String _serialNumber, Color _color, String _manufacturer, Date _manufactureDate,
            GearType _gearType, double _length, Engine _engine, int _chairNumber, boolean _isFurnitureLeather, double _width) {
        this.engine = _engine;
        this.chairNumber = _chairNumber;
        this.isFurnitureLeather = _isFurnitureLeather;
        this.plateNumber = _plateNumber;
        this.serialNumber = _serialNumber;
        this.manufacture = _manufacturer;
        this.manufactureDate = _manufactureDate;
        this.gearType = _gearType;
        this.width = _width;
        this.length = _length;
        this.color = _color;

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

    private void writeObject(ObjectOutputStream out) throws IOException {
        try {
            out.defaultWriteObject();
            out.writeObject(color);
            out.writeInt(chairNumber);
            out.writeDouble(length);
            out.writeDouble(width);
            out.writeBoolean(isFurnitureLeather);
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
            chairNumber = in.readInt();
            length = in.readDouble();
            width = in.readDouble();
            isFurnitureLeather = in.readBoolean();
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

    public void saveCarArrayList()
            throws UnsupportedEncodingException, FileNotFoundException, IOException, ClassNotFoundException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/harriharri/Desktop/App/vehicle_data.txt");
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(carList);
                objectOutputStream.flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
