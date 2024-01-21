import org.example.shapes.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RectangleTest {

    @Test
    public void expectRectangleCreationFailedForLength0(){
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rectangle = new Rectangle(0,10);
        });
    }

    @Test
    public void expectRectangleCreationFailedForBreadth0(){
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rectangle = new Rectangle(10,0);
        });
    }

    @Test
    public void expectArea200ForSides10And20(){
        int expected = 10*20;
        assertEquals(expected, new Rectangle(10,20).area());
    }

    @Test
    public void expectArea300ForSides10And30(){
        int expected = 10*30;
        assertEquals(expected, new Rectangle(10,30).area());
    }

    @Test
    public void expectCircumference60ForSides10And20(){
        int expected = 10+20+10+20;
        assertEquals(expected, new Rectangle(10,20).circumference());
    }

    @Test
    public void expectCircumference50ForSides10And15(){
        int expected = 10+15+10+15;
        assertEquals(expected, new Rectangle(10,15).circumference());
    }

    @Test
    public void expectSquareCreationFailedForSide0(){
        assertThrows(IllegalArgumentException.class,() ->{
            new Rectangle(0);
        });
    }

    @Test
    public void expectArea25ForSide5(){
        int expected = 5*5;
        assertEquals(expected, new Rectangle(5).area());
    }

    @Test
    public void expectArea100ForSide10(){
        int expected = 10*10;
        assertEquals(expected, new Rectangle(10).area());
    }

    @Test
    public void expectCircumference40ForSide10(){
        int expected = 10+10+10+10;
        assertEquals(expected, new Rectangle(10).circumference());
    }

    @Test
    public void expectCircumference20ForSide5(){
        int expected = 5+5+5+5;
        assertEquals(expected, new Rectangle(5).circumference());
    }
}
