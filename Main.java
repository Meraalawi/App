public class Main {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();
        manager.loadVehicleData("vehicle_data.ser");
        manager.start();
        manager.saveVehicleData("vehicle_data.ser");
    }
    }
