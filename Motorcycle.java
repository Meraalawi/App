public class Motorcycle extends Automobile{
    private double TierDiameter;
    private double Length;

    public Motorcycle(){
        this.TierDiameter = 0.0; 
        this.Length= 0.0; 
    }
    public Motorcycle(double TierDiameter, double Length) {
        this.TierDiameter = TierDiameter;
        this.Length = Length;
    }
    public double getTireDiameter() {
    return TierDiameter;
}

    public void setTireDiameter(double TierDiameter) {
        this.TierDiameter = TierDiameter;
    }

    public double getLength() {
        return Length;
    }

    public void setLength(double Length) {
        this.Length = Length;
    }
}
