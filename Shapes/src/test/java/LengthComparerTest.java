import comparers.LengthComparer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LengthComparerTest {

    @Test
    public void expectLengthCompareFailedForLengthWithoutUnit(){
        assertThrows(IllegalArgumentException.class, () ->{
           new LengthComparer("10", "10m");
        });
    }

    @Test
    public void expect1000For1km(){
        double expected = 1000.0;
        assertEquals(expected, new LengthComparer("0m","0cm").covertToMeter("1km"), 0.1);
    }

    @Test
    public void expect01For10cm(){
        double expected = 0.1;
        assertEquals(expected, new LengthComparer("0m","0cm").covertToMeter("10cm"), 0.1);
    }

    @Test
    public void expect1mIsGreaterThan1cm(){
        String expected = "Length1 1m is greater than length2 1cm.";
        assertEquals(expected, new LengthComparer("1m", "1cm").compare());
    }
}
