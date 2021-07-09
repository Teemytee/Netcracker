package tests;

import org.junit.Assert;
import org.junit.Test;
import shapes.Triangle;

public class TriangleTest {
    @Test
    public void triangleGetAreaTestWithNumberGreaterThanOne(){
        Triangle triangle = new Triangle(5.0, 5.0);
        double triangleArea = triangle.getArea();
        Assert.assertEquals(12.5, triangleArea, 0.0);
    }

    @Test
    public void triangleGetAreaTestWithNumberLesserThanOne(){
        Triangle triangle = new Triangle(0.5, 0.5);
        double triangleArea = triangle.getArea();
        Assert.assertEquals(0.125, triangleArea, 0.0);
    }

    @Test
    public void triangleGetAreaTestWithBigNumbers(){
        Triangle triangle = new Triangle(100.0, 50.0);
        double triangleArea = triangle.getArea();
        Assert.assertEquals(2500.0, triangleArea, 0.0);
    }
}
