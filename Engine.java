import java.text.SimpleDateFormat;
import java.util.Date;

public class Engine {
    private String manufacture;
    private Date manufactureDate;
    private String model;
    private int capacity;
    private int cylinder;
    private FuelType fuelType;

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void print() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Engine Details:");
        System.out.println("Manufacture: " + manufacture);
        if (manufactureDate != null) {
            System.out.println("Manufacture Date: " + sdf.format(manufactureDate));
        } else {
            System.out.println("Manufacture Date: Unknown");
        }        System.out.println("Model: " + model);
        System.out.println("Capacity: " + capacity );
        System.out.println("Cylinders: " + cylinder);
        System.out.println("Fuel Type: " + fuelType);
    }
 }
