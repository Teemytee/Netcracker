package shapes;

public class Triangle implements Shape {
    private double width;
    private double height;

    public Triangle(double width, double height){
        if(width <= 0 || height <= 0){
            throw new IllegalArgumentException("triangle width/height cannot be lesser/equal than 0");
        } else{
            this.width = width;
            this.height = height;
        }
    }

    @Override
    public double getArea() {
        double triangleArea = (this.width * this.height) / 2;
        return triangleArea;
    }
}
