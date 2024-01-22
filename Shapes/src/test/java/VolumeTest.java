import org.junit.Test;
import units.Volume;
import units.Weight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class VolumeTest {
    @Test
    public void expectVolumeCreationFailedForNegativeVolume(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Volume(-10, Volume.Unit.ML);
        });
    }

    @Test
    public void expectVolumeEqualWithEqualValueSameUnit() {
        Volume volume1 = new Volume(10, Volume.Unit.CL );
        Volume volume2 = new Volume(10, Volume.Unit.CL);

        assertEquals(volume1, volume2);
    }

    @Test
    public void expectVolumeEqualFor100clAnd1l() {
        Volume volume1 = new Volume(100, Volume.Unit.CL );
        Volume volume2 = new Volume(1, Volume.Unit.L);

        assertEquals(volume1, volume2);
    }

    @Test
    public void expectVolumeEqualFor1klAnd1000l() {
        Volume volume1 = new Volume(1000, Volume.Unit.L );
        Volume volume2 = new Volume(1, Volume.Unit.KL);

        assertEquals(volume1, volume2);
    }

    @Test
    public void expectVolume110clWhenAdding10clAnd1l(){
        Volume expected = new Volume(110, Volume.Unit.CL);
        Volume actual = new Volume(10, Volume.Unit.CL).add(new Volume(1, Volume.Unit.L));
        assertEquals(expected, actual);
    }

    @Test
    public void expect1WhenComparing1lTo1cl(){
        int expected = 1;
        int actual = new Volume(1, Volume.Unit.L).compareTo(new Volume(1, Volume.Unit.CL));
        assertEquals(expected,actual);
    }

    @Test
    public void expectNegativeWhenComparing1lTo1cl(){
        int expected = -1;
        int actual = new Volume(1, Volume.Unit.CL).compareTo(new Volume(1, Volume.Unit.L));
        assertEquals(expected,actual);
    }

    @Test
    public void expect0WhenComparing1000lTo1kl(){
        int expected = 0;
        int actual = new Volume(1000, Volume.Unit.L).compareTo(new Volume(1, Volume.Unit.KL));
        assertEquals(expected,actual);
    }
}
