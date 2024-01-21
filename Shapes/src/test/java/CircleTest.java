import org.example.shapes.Circle;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class CircleTest {

    @Test
    public void expectCircleCreationFailedForRadius0(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Circle(0);
        });
    }
}
