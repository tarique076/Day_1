import org.example.shapes.Circle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CircleTest {

    @Test
    public void expectCircleCreationFailedForRadius0(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Circle(0);
        });
    }

    @Test
    public void expectValidCircleAreaForRadius5() {
        double expected = Math.PI*5*5;
        Circle circle = new Circle(5);
        assertEquals(expected, circle.area(),0.001);
    }

    @Test
    public void expectValidCircleAreaForRadius10() {
        double expected = Math.PI*10*10;
        Circle circle = new Circle(10);
        assertEquals(expected, circle.area(),0.001);
    }

    @Test
    public void testCircumferenceValidForRadius5() {
        double expected = 2 * Math.PI * 5;
        Circle circle = new Circle(5);
        assertEquals(expected, circle.circumference(),0.001);
    }

    @Test
    public void testCircumferenceValidForRadius10() {
        double expected = 2 * Math.PI * 10;
        Circle circle = new Circle(10);
        assertEquals(expected, circle.circumference(),0.001);
    }
}
