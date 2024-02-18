class Vehicle extends Automobile {
    private double width;
    private double length;
    private Color color;

    public Vehicle(){
        this.width = 0.0;
        this.length = 0.0;
        this.color = null;
    }
    public Vehicle(double width, double length, Color color) {
        this.width = width;
        this.length = length;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
