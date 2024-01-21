import org.example.shapes.Triangle;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class TriangleTest {

    @Test
    public void expectTriangleCreationfailedForAnySide0(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(0,10,20);
        });
    }
}
