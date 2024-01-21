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
}
