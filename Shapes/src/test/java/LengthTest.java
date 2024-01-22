import comparers.LengthComparer;
import org.junit.Test;
import units.Length;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LengthTest {

    @Test
    public void expectLengthCreationFailedForNegativeLength(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Length(-10, Length.Unit.MM);
        });
    }

    @Test
    public void expectLengthEqualWithEqualValueSameUnit() {
        Length length1 = new Length(10, Length.Unit.CM );
        Length length2 = new Length(10, Length.Unit.CM);

        assertEquals(length1, length2);
    }

    @Test
    public void expectLengthEqualFor100cmAnd1m() {
        Length length1 = new Length(100, Length.Unit.CM );
        Length length2 = new Length(1, Length.Unit.M);

        assertEquals(length1, length2);
    }

    @Test
    public void expectLengthEqualFor1kmAnd1000m() {
        Length length1 = new Length(100, Length.Unit.CM );
        Length length2 = new Length(1, Length.Unit.M);

        assertEquals(length1, length2);
    }

    @Test
    public void expectLength110cmWhenAdding10cmAnd1m(){
        Length expected = new Length(110, Length.Unit.CM);
        Length actual = new Length(10, Length.Unit.CM).add(new Length(1, Length.Unit.M));
        assertEquals(expected, actual);
    }

    @Test
    public void expect1WhenComparing1mTo1cm(){
        int expected = 1;
        int actual = new Length(1, Length.Unit.M).compareTo(new Length(1, Length.Unit.CM));
        assertEquals(expected,actual);
    }

    @Test
    public void expectNegativeWhenComparing1mTo1cm(){
        int expected = -1;
        int actual = new Length(1, Length.Unit.CM).compareTo(new Length(1, Length.Unit.M));
        assertEquals(expected,actual);
    }

    @Test
    public void expect0WhenComparing1000mTo1km(){
        int expected = 0;
        int actual = new Length(1000, Length.Unit.M).compareTo(new Length(1, Length.Unit.KM));
        assertEquals(expected,actual);
    }
}
