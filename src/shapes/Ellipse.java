package shapes;

public class Ellipse implements Shape {
    private double longSemiAxis;
    private double shortSemiAxis;

    public Ellipse(double longSemiAxis, double shortSemiAxis){
        if (longSemiAxis <= 0 || shortSemiAxis <= 0){
            throw new IllegalArgumentException("Ellipse long semi-axis or short semi axis " +
                    "cannot be lesser/equal to zero");
        } else {
            this.longSemiAxis = longSemiAxis;
            this.shortSemiAxis = shortSemiAxis;
        }
    }

    public double getArea(){
        double ellipseArea = Math.PI * (this.longSemiAxis * this.shortSemiAxis);
        return ellipseArea;
    }
}
