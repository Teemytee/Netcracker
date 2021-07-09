import shapes.Circle;
import shapes.Ellipse;
import shapes.Square;
import shapes.Triangle;

public class Main {

    public static void main(String[] args) {
        Square square = new Square(6.0);
        System.out.println(String.format("Square area: %s", square.getArea()));

        Triangle triangle = new Triangle(10, 12);
        System.out.println(String.format("Triangle area: %s", triangle.getArea()));

        Circle circle = new Circle(0.5);
        System.out.println(String.format("Circle area: %s", circle.getArea()));

        Ellipse ellipse = new Ellipse(15.0, 12.0);
        System.out.println(String.format("Ellipse area: %s", ellipse.getArea()));
    }
}
