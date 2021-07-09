package shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius){
        if (radius <= 0){
            throw new IllegalArgumentException("Circle radius cannot be lesser/equal to zero");
        } else{
            this.radius = radius;
        }
    }

    @Override
    public double getArea() {
        double circleArea = Math.PI * (this.radius * this.radius);
        return circleArea;
    }
}
