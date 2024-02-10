public class Car {
    private int chairNumber;
    private boolean isFurnitureLeather;

    public Car(){
        this.chairNumber = 0;
        this.isFurnitureLeather = true;
    } 
    
    public Car(int chairNumber, boolean isFurnitureLeather) {
        this.chairNumber = chairNumber;
        this.isFurnitureLeather = isFurnitureLeather;
    }

    public int getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(int chairNumber) {
        this.chairNumber = chairNumber;
    }

    public boolean isFurnitureLeather() {
        return isFurnitureLeather;
    }

    public void setFurnitureLeather(boolean furnitureLeather) {
        isFurnitureLeather = furnitureLeather;
    }
}
