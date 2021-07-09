package tests;

import org.junit.Assert;
import org.junit.Test;
import shapes.Square;

public class SquareTest {
    @Test
    public void squareGetAreaTestWithNumberGreaterThanOne() {
        Square square = new Square(5.0);
        double squareArea = square.getArea();
        Assert.assertEquals(25.0, squareArea, 0);
    }

    @Test
    public void squareGetAreaTestWithNumberLesserThanOne(){
        Square square = new Square(0.5);
        double squareArea = square.getArea();
        Assert.assertEquals(0.25, squareArea, 0.0);
    }

    @Test
    public void squareGetAreaTestWithBigNumbers(){
        Square square = new Square(100.0);
        double squareArea = square.getArea();
        Assert.assertEquals(10000.0, squareArea, 0.0);
    }


}
