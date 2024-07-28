public class Main {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();
        manager.loadVehicleData("/Users/harriharri/Desktop/App/vehicle_data.txt");
        manager.start();
        manager.saveVehicleData("vehicle_data.txt");
    }
    }
