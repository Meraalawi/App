public class Car extends Vehicle {
    private int chairNumber;
    private boolean isFurnitureLeather;

    public Car() {
        super(0.0, 0.0, null);
        this.chairNumber = 0;
        this.isFurnitureLeather = true;
    } 
    
    public Car(int chairNumber, boolean isFurnitureLeather, double width, double length, Color color) {
        super(width, length, color);
        this.chairNumber = chairNumber;
        this.isFurnitureLeather = isFurnitureLeather;
    }

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }

    public boolean getIsFurnitureLeather() {
        return isFurnitureLeather;
    }

    public void setIsFurnitureLeather(boolean isFurnitureLeather) {
        this.isFurnitureLeather = isFurnitureLeather;
    }
}
