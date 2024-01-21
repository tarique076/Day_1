import comparers.LengthComparer;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class LengthComparerTest {

    @Test
    public void expectLengthCompareFailedForLengthWithoutUnit(){
        assertThrows(IllegalArgumentException.class, () ->{
           new LengthComparer("10", "10m");
        });
    }
}
