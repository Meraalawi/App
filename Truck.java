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
}
