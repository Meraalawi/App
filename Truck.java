public class Truck extends Vehicle {
    private double freeWeight;
    private double fullWeight;

    public Truck() {
        super(0.0, 0.0, null);
        this.freeWeight = 0.0;
        this.fullWeight = 0.0;
    }

    public Truck(double freeWeight, double fullWeight, double width, double length, Color color) {
        super(width, length, color);
        this.freeWeight = freeWeight;
        this.fullWeight = fullWeight;
    }

    public double getFreeWeight() {
        return this.freeWeight;
    }

    public void setFreeWeight(double freeWeight) {
        this.freeWeight = freeWeight;
    }

    public double getFullWeight() {
        return this.fullWeight;
    }

    public void setFullWeight(double fullWeight) {
        this.fullWeight = fullWeight;
    }
    public void print() {
        System.out.println("Truck Details:");
        System.out.println("Width: " + getWidth());
        System.out.println("Length: " + getLength());
        System.out.println("Color: " + getColor());
        System.out.println("Free Weight: " + freeWeight);
        System.out.println("Full Weight: " + fullWeight);
        System.out.println("Plate Number: " + getPlateNumber());
        System.out.println("Serial Number: " + getSerialNumber());
        System.out.println("Manufacturer: " + getManufacture());
        System.out.println("Manufacture Date: " + getManufactureDate());
        System.out.println("Fuel Type: " + getFuelType());
        System.out.println("Gear Type: " + getGearType());
        System.out.println("Engine: ");
        getEngine().print();
    }
}
