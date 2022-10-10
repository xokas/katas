import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplyDoubleTest {
    @Test
    public void multiplyTest() {
        assertEquals(Double.valueOf(4.0), MultiplyDouble.multiply(Double.valueOf(2), Double.valueOf(2)));
    }
}
