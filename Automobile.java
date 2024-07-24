import java.util.Date;

public class Automobile {
    protected String manufacture;
    protected Date manufactureDate;
    protected Engine engine;
    protected String plateNumber;
    protected FuelType fuelType;
    protected GearType gearType;
    protected String serialNumber;


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