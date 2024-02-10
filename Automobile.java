import java.sql.Date;

public class Automobile {
    private String Manufacture;
    private Date ManufactureDate;
    private Engine Engine;
    private int PlateNumber;
    private FuelType FuelType;
    private GearType GearType;
    private int SerialNumber;

    public String getManufacture(){
        return Manufacture;
    }
    public void setManufacture(String Manufacture){
        this.Manufacture=Manufacture;
    }
    public Date getManufactureDate(){
        return ManufactureDate;
    }
    public void setManufactureDate(Date ManufactureDate){
        this.ManufactureDate=ManufactureDate;
    }
    public Engine getEngine(){
        return Engine;
    }
    public void setEngine(Engine Engine){
        this.Engine=Engine;
    }
    public int getPlateNumber(){
        return PlateNumber;
    }
    public void setPlateNumber(int PlateNumber){
        this.PlateNumber=PlateNumber;
    }
    public FuelType getFuelType(){
        return FuelType;
    }
    public void setFuelType(FuelType FuelType){
        this.FuelType=FuelType;
    }
    public GearType getGearType(){
        return GearType;
    }
    public void setGearType(GearType GearType){
        this.GearType=GearType;
    }
    public int getSerialNumber(){
        return SerialNumber;
    }
    public void SerialNumber(int SerialNumber){
        this.SerialNumber=SerialNumber;
    }

}
