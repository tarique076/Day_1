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
        assertEquals(expected, new LengthComparer("0m","0cm").convertToMeter("1km"), 0.1);
    }

    @Test
    public void expect01For10cm(){
        double expected = 0.1;
        assertEquals(expected, new LengthComparer("0m","0cm").convertToMeter("10cm"), 0.1);
    }

    @Test
    public void expect1mIsGreaterThan1cm(){
        String expected = "Length1 1m is greater than length2 1cm.";
        assertEquals(expected, new LengthComparer("1m", "1cm").compare());
    }

    @Test
    public void expect1kmIsGreaterThan1m(){
        String expected = "Length2 1km is greater than length1 1m.";
        assertEquals(expected, new LengthComparer("1m", "1km").compare());
    }

    @Test
    public void expect1mIsEqualTo100cm(){
        String expected = "Length1 1m is equal to length2 100cm.";
        assertEquals(expected, new LengthComparer("1m", "100cm").compare());
    }

    @Test
    public void expect1000mmFor1m(){
        double expected = 1000.0;
        assertEquals(expected, new LengthComparer("1mm", "10cm").convertTomm("1m"),0.1);
    }

    @Test
    public void expect100mmFor1cm(){
        double expected = 100.0;
        assertEquals(expected, new LengthComparer("1mm", "10cm").convertTomm("1cm"),0.1);
    }

    @Test
    public void expect100cmFor1m(){
        double expected = 100.0;
        assertEquals(expected, new LengthComparer("10cm", "1m").convertTocm("1m"),0.1);
    }

    @Test
    public void expect01cmFor1mm(){
        double expected = 0.1;
        assertEquals(expected, new LengthComparer("10cm", "1m").convertTocm("1mm"),0.1);
    }

    @Test
    public void expect00001kmFor1m(){
        double expected = 0.001;
        assertEquals(expected, new LengthComparer("10cm", "1m").convertTokm("1m"),0.00001);
    }

    @Test
    public void expect110cmFor1m10cm(){
        String expected = "110.0cm";
        assertEquals(expected, new LengthComparer("1m","10cm").add());
    }

    @Test
    public void expect1001kmFor1m1km(){
        String expected = "1.001km";
        assertEquals(expected, new LengthComparer("1m","1km").add());
    }

    @Test
    public void expect1001mFor1km1m(){
        String expected = "1001.0m";
        assertEquals(expected, new LengthComparer("1km","1m").add());
    }

    @Test
    public void expectSubtractionFailFor1kmMinus1m(){
        assertThrows(IllegalArgumentException.class, () -> {
           new LengthComparer("1km", "1m");
        });
    }
}
