class Vehicle extends Automobile {
    private double width;
    private double length;
    private Color color;

    public Vehicle(double _width, double _length, Color _color) {
        super();
        this.width = _width;
        this.length = _length;
        this.color = _color;
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
