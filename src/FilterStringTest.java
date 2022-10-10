import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilterStringTest {
    @Test
    public void examples() {
        assertTrue(Arrays.deepEquals(List.of(1, 2).toArray(), FilterString.filterList(List.of(1, 2, "a", "b")).toArray()));
    }
}
