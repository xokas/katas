import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

// TODO: Replace examples and use TDD development by writing your own tests

public class BurrowsWheelerTest {

    @Test
    public void decodeTests() {
        assertEquals("bananabar",     BurrowsWheeler.decode("nnbbraaaa", 4));
        assertEquals("Humble Bundle", BurrowsWheeler.decode("e emnllbduuHB", 2));
        assertEquals("Mellow Yellow", BurrowsWheeler.decode("ww MYeelllloo", 1));
    }

    @Test
    public void encodeTests() {
        assertEquals(new BWT("nnbbraaaa", 4),     BurrowsWheeler.encode("bananabar"));
        assertEquals(new BWT("e emnllbduuHB", 2), BurrowsWheeler.encode("Humble Bundle"));
        assertEquals(new BWT("ww MYeelllloo", 1), BurrowsWheeler.encode("Mellow Yellow"));
    }

    @Test
    public void shiftStringTests() {
        assertEquals("annbbraaa", BurrowsWheeler.shiftString("nnbbraaaa"));
    }

    @Test
    public void createMatrixTests() {
        String[] matrix0 = {"abc", "bca", "cab"};
        List<String> result = BurrowsWheeler.createMatrix("abc");
        Utilities.printStringArray(matrix0);
        Utilities.printListStringArray(result);

        List<String> result2 = BurrowsWheeler.createMatrix("Humble Bundle");
        Utilities.printListStringArray(result2);
        List<String> result3 = BurrowsWheeler.createMatrix("Mellow Yellow");
        Utilities.printListStringArray(result3);

        assertTrue(Arrays.deepEquals(matrix0, result.toArray()));
    }
}
