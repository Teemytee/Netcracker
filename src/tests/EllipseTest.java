package tests;

import org.junit.Assert;
import org.junit.Test;
import shapes.Circle;
import shapes.Ellipse;

public class EllipseTest {
    @Test
    public void ellipseGetAreaWithNumbersGreaterThanOne(){
        Ellipse ellipse = new Ellipse(5.0, 2.0);
        double ellipseArea = ellipse.getArea();
        Assert.assertEquals(31.41, ellipseArea, 0.01);
    }

    @Test
    public void ellipseGetAreaWithNumbersLesserThanOne(){
        Ellipse ellipse = new Ellipse(0.5, 0.2);
        double ellipseArea = ellipse.getArea();
        Assert.assertEquals(0.314, ellipseArea, 0.01);
    }

    @Test
    public void ellipseGetAreaWithBigNumbers(){
        Ellipse ellipse = new Ellipse(15.0, 12.0);
        double ellipseArea = ellipse.getArea();
        Assert.assertEquals(565.48, ellipseArea, 0.01);
    }
}
