import java.util.HashMap;
import java.util.Map;
enum FuelType {
    NOT_DEFINE, 
    DIESEL,
    GASOLINE,
    HYBIRD,
    ELCTRIC;
    public static FuelType getFuelTypeFromInput() {
        Map<Integer, FuelType> fuelTypeMap = new HashMap<>();
        System.out.println("Enter fuel type:\n1: NOT_DEFINE\n2: Diesel\n3: Gasoline\n4: Electric\n5: Hybrid");
        fuelTypeMap.put(1, FuelType.NOT_DEFINE);
        fuelTypeMap.put(2, FuelType.DIESEL);
        fuelTypeMap.put(3, FuelType.GASOLINE);
        fuelTypeMap.put(4, FuelType.ELCTRIC);
        fuelTypeMap.put(5, FuelType.HYBIRD);
        int choice = getUserChoice(fuelTypeMap.size());

        return fuelTypeMap.get(choice);
    }

    // Placeholder method
    private static int getUserChoice(int numOptions) {
        return 1; 
    }
}
    