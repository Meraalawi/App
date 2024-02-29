import java.util.Date;

public class Automobile {
    private String manufacture;
    private Date manufactureDate;
    private Engine engine;
    private int plateNumber;
    private FuelType fuelType;
    private GearType gearType;
    private int serialNumber;

    public Automobile() {
        this.manufacture = null;
        this.manufactureDate = new Date();
        this.engine = null;
        this.plateNumber = 0;
        this.fuelType = null;
        this.gearType = null;
        this.serialNumber = 0;
    }

    public Automobile(String manufacture, Date manufactureDate, Engine engine, int plateNumber, FuelType fuelType, GearType gearType, int serialNumber) {
        this.manufacture = manufacture;
        this.manufactureDate = manufactureDate;
        this.engine = engine;
        this.plateNumber = plateNumber;
        this.fuelType = fuelType;
        this.gearType = gearType;
        this.serialNumber = serialNumber;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public GearType getGearType() {
        return gearType;
    }

    public void setGearType(GearType gearType) {
        this.gearType = gearType;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}