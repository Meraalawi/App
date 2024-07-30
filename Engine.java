import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import  java.util.Scanner;

public class Engine implements Serializable {
    private static final long serialVersionUID = 1L;
    private String manufacture;
    private Date manufactureDate;
    private String model;
    private int capacity;
    private int cylinder;
    private FuelType fuelType;

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Engine> engineList = new ArrayList<>();
public Engine(String manufacture, Date manufactureDate, String model, int capacity, int cylinder, FuelType fuelType) {
        this.manufacture = manufacture;
        this.manufactureDate = manufactureDate;
        this.model = model;
        this.capacity = capacity;
        this.cylinder = cylinder;
        this.fuelType = fuelType;
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
    public  static int getEngineCylinderCount() {
        int cylinder;
        do {
            System.out.print("Enter engine cylinder count (max 16): ");
            cylinder = scanner.nextInt();
            if (cylinder > 16) {
                System.out.println("Cylinder count exceeds maximum allowed (16). Please enter again.");
            }
        } while (cylinder > 16);
        return cylinder;
}
    public static int getEngineCapacity() {
        int capacity;
        do {
            System.out.print("Enter engine capacity (max 1350): ");
            capacity = scanner.nextInt();
            if (capacity > 1350) {
                System.out.println("Capacity exceeds maximum allowed (1350). Please enter again.");
            }
        } while (capacity > 1350);
        return capacity;
    }
    public static String getEngineModel() {
        String engineModel;
        while (true) {
            System.out.print("Enter engine model (alphanumeric only, length 1-50): ");
            engineModel = scanner.nextLine().trim();
            if (engineModel.matches("[a-zA-Z0-9 ]{1,50}")) { 
                return engineModel;
            } else {
                System.out.println("Invalid input. Please enter a valid engine model (alphanumeric only, length 1-50).");
            }
        }
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
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Write default fields
        out.writeObject(manufacture); // Serialize custom fields
        out.writeObject(manufactureDate);
        out.writeObject(model);
        out.writeInt(capacity);
        out.writeInt(cylinder);
        out.writeObject(fuelType); // Assuming FuelType is Serializable
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Read default fields
        manufacture = (String) in.readObject(); // Deserialize custom fields
        manufactureDate = (Date) in.readObject();
        model = (String) in.readObject();
        capacity = in.readInt();
        cylinder = in.readInt();
        fuelType = (FuelType) in.readObject(); // Assuming FuelType is Serializable
    }
    public void loadEngineArrayList() {
        String filename = "C:/Users/harriharri/Desktop/App/engine_data.txt"; // Adjust path as needed
        try (FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            engineList.clear(); 
            engineList.addAll((ArrayList<Engine>) objectInputStream.readObject());
            System.out.println("Engine data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading engine data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void saveEngineArrayList() throws IOException {
        String filename = "C:/Users/harriharri/Desktop/App/engine_data.txt"; // Adjust path as needed
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(engineList);
            objectOutputStream.flush();
            System.out.println("Engine data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving engine data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<Engine> getEngineList() {
        return engineList;
    }
}

