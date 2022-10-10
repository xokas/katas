import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;


public class ThreeDigitsSumTest {

    @Test
    public void exampleTests() {
        assertEquals(Arrays.asList(8L, 118L, 334L),         ThreeDigitsSum.findAll(10, 3));
        assertEquals(Arrays.asList(1L, 999L, 999L),         ThreeDigitsSum.findAll(27, 3));
        assertEquals(new ArrayList<Long>(),                 ThreeDigitsSum.findAll(84, 4));
        assertEquals(Arrays.asList(123L, 116999L, 566666L), ThreeDigitsSum.findAll(35, 6));
    }

    @Test
    public void getMaxTests() {
        assertEquals(333, ThreeDigitsSum.getMax(9, 3));
        assertEquals(334, ThreeDigitsSum.getMax(10, 3));
        assertEquals(4444, ThreeDigitsSum.getMax(16, 4));
        assertEquals(4455, ThreeDigitsSum.getMax(18, 4));
        assertEquals(566666L, ThreeDigitsSum.getMax(35, 6));
        assertEquals(0, ThreeDigitsSum.getMax(84, 4));
    }

    @Test
    public void getMinTests() {
        assertEquals(118, ThreeDigitsSum.getMin(1, 10, 3));
        assertEquals(999, ThreeDigitsSum.getMin(1, 27, 3));
        assertEquals(0, ThreeDigitsSum.getMin(1, 84, 4));
    }

    @Test
    public void getCombinationsTests() {
        // assertEquals(118, ThreeDigitsSum.getMin(1, 10, 3));
        assertEquals(8L, ThreeDigitsSum.getCombinations(3, 10, new ArrayList<String>()));
        assertEquals(123L, ThreeDigitsSum.getCombinations( 6, 35, new ArrayList<String>()));
    }
}