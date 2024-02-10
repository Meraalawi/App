public class Truck extends Vehicle {
    private double FreeWight;
    private double FullWight;

    public Truck() {
        this.FreeWight = 0.0;
        this.FullWight = 0.0;
    }  
    public Truck(double FreeWight,double FullWight) {
        this.FreeWight=FreeWight;
        this.FullWight=FullWight;
    }
        
    public double getFreeWight() {
        return this.FreeWight;
    }

    public void setFreeWight(double freeWight) {
        this.FreeWight = freeWight;
    }

    public double getFullWight() {
        return this.FullWight;
    }

    public void setFullWight(double fullWight) {
        this.FullWight = fullWight;
    }
}