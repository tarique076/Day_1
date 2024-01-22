import org.junit.Test;
import units.Weight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class WeightTest {

    @Test
    public void expectWeightCreationFailedForNegativeLength(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Weight(-10, Weight.Unit.MG);
        });
    }

    @Test
    public void expectWeightEqualWithEqualValueSameUnit() {
        Weight weight1 = new Weight(10, Weight.Unit.CG );
        Weight weight2 = new Weight(10, Weight.Unit.CG);

        assertEquals(weight1, weight2);
    }

    @Test
    public void expectWeightEqualFor100cgAnd1g() {
        Weight weight1 = new Weight(100, Weight.Unit.CG );
        Weight weight2 = new Weight(1, Weight.Unit.G);

        assertEquals(weight1, weight2);
    }

    @Test
    public void expectWeightEqualFor1kgAnd1000g() {
        Weight weight1 = new Weight(100, Weight.Unit.CG );
        Weight weight2 = new Weight(1, Weight.Unit.G);

        assertEquals(weight1, weight2);
    }

    @Test
    public void expectWeight110cgWhenAdding10cgAnd1g(){
        Weight expected = new Weight(110, Weight.Unit.CG);
        Weight actual = new Weight(10, Weight.Unit.CG).add(new Weight(1, Weight.Unit.G));
        assertEquals(expected, actual);
    }

    @Test
    public void expect1WhenComparing1gTo1cg(){
        int expected = 1;
        int actual = new Weight(1, Weight.Unit.G).compareTo(new Weight(1, Weight.Unit.CG));
        assertEquals(expected,actual);
    }

    @Test
    public void expectNegativeWhenComparing1gTo1cg(){
        int expected = -1;
        int actual = new Weight(1, Weight.Unit.CG).compareTo(new Weight(1, Weight.Unit.G));
        assertEquals(expected,actual);
    }

    @Test
    public void expect0WhenComparing1000gTo1kg(){
        int expected = 0;
        int actual = new Weight(1000, Weight.Unit.G).compareTo(new Weight(1, Weight.Unit.KG));
        assertEquals(expected,actual);
    }
}
