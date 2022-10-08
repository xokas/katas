import java.math.BigInteger;

public class MatrixDeterminant {

    public static int determinant(int[][] matrix){
        int d = 0;
        int size = matrix.length;
        if (size == 1) return matrix[0][0];

        for (int i = 0 ; i < size ; i++) {
            int[][] newMatrix = reduce(matrix, i);
            //d += (i % 2 != 0 ? -1 : 1) * matrix[0][i] * determinant(newMatrix);
            d += Math.pow(-1, i) * matrix[0][i] * determinant(newMatrix);
        }
        return d;
    }

    static int[][] reduce(int[][] matrix, int a) {
        int[][] result = new int[matrix.length - 1][ matrix.length - 1];
        int m = 0;
        int n = 0;
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(j != a){
                    result[m][n] = matrix[i][j];
                    n++;
                }
            }
            n = 0;
            m++;
        }
        return result;
    }
}
