package tests;

import org.junit.Assert;
import org.junit.Test;
import shapes.Circle;

public class CricleTest {
    @Test
    public void circleGetAreaWithNumbersGreaterThanOne(){
        Circle circle = new Circle(2.0);
        double circleArea = circle.getArea();
        Assert.assertEquals(12.56, circleArea, 0.01);
    }

    @Test
    public void circleGetAreaWithNumbersLesserThanOne(){
        Circle circle = new Circle(0.5);
        double circleArea = circle.getArea();
        Assert.assertEquals(0.785, circleArea, 0.01);
    }

    @Test
    public void circleGetAreaWithBigNumbers(){
        Circle circle = new Circle(15.0);
        double circleArea = circle.getArea();
        Assert.assertEquals(706.85, circleArea, 0.01);
    }
}
