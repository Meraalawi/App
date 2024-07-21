import java.util.Date;

public interface VehicleOperations {
    void addVehicle(int listChoice);
    void searchVehicle(int listChoice);
    void deleteVehicle(int listChoice);
    void modifyVehicle(int listChoice);
    String getPlateNumber();
    String getSerialNumber();
    Engine addEngineDetails();
    int getChairNumber();
    int getLength();
    double getWidth(int listChoice);
    Date getDateInput(String promptMessage);
    String getManufacturer();
    boolean parseBooleanInput();
}
