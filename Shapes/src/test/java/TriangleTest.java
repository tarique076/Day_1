import org.example.shapes.Triangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TriangleTest {

    @Test
    public void expectTriangleCreationfailedForAnySide0(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(0,10,20);
        });
    }

    @Test
    public void expectTriangleCreationFailedIfSumOf2SideLessThanEqualTo3rdSide(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(5,10,30);
        });
    }
    @Test
    public void expectValidAreaForSides10_15And20(){
        double semiPerimeter = (10+15+20)/2;
        double expected = Math.sqrt(semiPerimeter*(semiPerimeter-10)*(semiPerimeter-15)*(semiPerimeter-20));

        assertEquals(expected, new Triangle(10,15,20).area(),0.001);
    }

    @Test
    public void expectValidAreaForSides5_12And15(){
        double semiPerimeter = (10+15+20)/2;
        double expected = Math.sqrt(semiPerimeter*(semiPerimeter-10)*(semiPerimeter-15)*(semiPerimeter-20));

        assertEquals(expected, new Triangle(10,15,20).area(),0.001);
    }

    @Test
    public void expectValidCircumferenceForSides10_15And20(){
        double expected = 10+15+20;

        assertEquals(expected, new Triangle(10,15,20).circumference(),0.001);
    }

    @Test
    public void expectValidCircumferenceForSides5_12And15(){
        double expected = 5+12+15;

        assertEquals(expected, new Triangle(5,12,15).circumference(),0.001);
    }
}
