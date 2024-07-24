import java.util.Date;

public class Automobile {
    private String manufacture;
    private Date manufactureDate;
    private Engine engine;
    private String plateNumber;
    private FuelType fuelType;
    private GearType gearType;
    private String serialNumber;

    public Automobile() {
        this.manufacture = null;
        this.manufactureDate = new Date();
        this.engine = null;
        this.plateNumber = null;
        this.fuelType = null;
        this.gearType = null;
        this.serialNumber = null;
    }

    public Automobile(String ـmanufacture, Date ـmanufactureDate, Engine ـengine, String ـplateNumber, FuelType ـfuelType, GearType ـgearType, String ـserialNumber) {
        this.manufacture = ـmanufacture;
        this.manufactureDate = ـmanufactureDate;
        this.engine = ـengine;
        this.plateNumber = ـplateNumber;
        this.fuelType = ـfuelType;
        this.gearType = ـgearType;
        this.serialNumber = ـserialNumber;
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

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}