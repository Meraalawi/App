import java.sql.Date;

public class Engine {
    private String Manufacture;
    private Date ManufactureDate;
    private String Model;
    private int Capacity;
    private int Cylinder;
    private FuelType FuelType;

    public String getManufacture() {
        return Manufacture;
    }
    public void setManufacture(String Manufacture) {
        this.Manufacture = Manufacture;
    }
    public Date getManufactureDate() {
        return ManufactureDate;
    }
    public void setManufactureDate(Date ManufactureDate) {
        this.ManufactureDate = ManufactureDate;
    }

    public String getModel(){
        return Model;
    }
    public int getCapcity(){
        return Capacity;
    }
    public int getCylinder(){
        return Cylinder;
    }
    public FuelType getFuelType(){
        return FuelType;
    }
}
