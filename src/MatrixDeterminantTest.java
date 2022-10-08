import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runners.JUnit4;

import java.util.Arrays;

public class MatrixDeterminantTest {
    private static int[][][] matrix = { {{1}},
            {{1, 3}, {2,5}},
            {{2,5,3}, {1,-2,-1}, {1, 3, 4}},
            {{2,5,3,4}, {1,-2,-1,5}, {1, 3, 4,1},{2, 3, 4, 5}},
            {{2,5,3,4,1}, {1,-2,-1,5,1}, {1, 3, 4,1,1},{2, 3, 4, 5,1},{1,1,1,1,1}}};

    private static int[] expected = {1, -1, -20, -6, 27};

    private static String[] msg = {"Determinant of a 1 x 1 matrix yields the value of the one element",
            "Should return 1 * 5 - 3 * 2 == -1 ",
            "","",""};

    @Test
    public void sampleTests() {
        for (int n = 0 ; n < expected.length ; n++)
            assertEquals(msg[n], expected[n], MatrixDeterminant.determinant(matrix[n]));
    }

    @Test
    public void reduceTest() {
        int[][] matrix = {{ 2, 5, 3},
                          { 1,-2,-1},
                          { 1, 3, 4}};
        int[][] matrix0 = {{-2,-1},
                           { 3, 4}};
        int[][] matrix1 = {{ 1,-1},
                           { 1, 4}};
        int[][] matrix2 = {{ 1,-2},
                           { 1, 3}};
        int[][] res0 = MatrixDeterminant.reduce(matrix, 0);
        int[][] res1 = MatrixDeterminant.reduce(matrix, 1);
        int[][] res2 = MatrixDeterminant.reduce(matrix, 2);
        assertTrue(Arrays.deepEquals(matrix0, res0));
        assertTrue(Arrays.deepEquals(matrix1, res1));
        assertTrue(Arrays.deepEquals(matrix2, res2));
    }
}
