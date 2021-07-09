package shapes;

public class Square implements Shape {
    private double side;

    public Square(double side){
        if (side <= 0){
            throw new IllegalArgumentException("Square side cannot be less or equal to zero");
        } else{
            this.side = side;
        }
    }

    @Override
    public double getArea() {
        double area = this.side * this.side;
        return area;
    }
}
