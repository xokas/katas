
/*Given a 2D array and a number of generations, compute n timesteps of Conway's Game of Life.

The rules of the game are:

Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
Any live cell with more than three live neighbours dies, as if by overcrowding.
Any live cell with two or three live neighbours lives on to the next generation.
Any dead cell with exactly three live neighbours becomes a live cell.
Each cell's neighborhood is the 8 cells immediately around it (i.e. Moore Neighborhood). The universe is infinite in both the x and y dimensions and all cells are initially dead - except for those specified in the arguments. The return value should be a 2d array cropped around all of the living cells. (If there are no living cells, then return [[]].)

For illustration purposes, 0 and 1 will be represented as ░░ and ▓▓ blocks respectively (PHP, C: plain black and white squares). You can take advantage of the htmlize function to get a text representation of the universe, e.g.:

System.out.println(LifeDebug.htmlize(cells));*/

import java.util.Arrays;

public class ConwayLife {

    public static int[][] conwayLife(int[][] cells, int n) {
        for(int k = 0; k < n; k++) {
            cells = expand(cells);
            int[][] result = new int[cells.length][cells[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = checkCell(cells, i, j);
                }
            }
            cells = crop(result);
        }
        return cells;
    }

    public static int[][] deepCopy(int[][] cells){
        return deepCopy(cells, 0, cells.length, 0, cells[0].length);
    }

    public static int[][] deepCopy(int[][] cells, int rowStart, int rowEnd, int columnStart, int columnEnd){
        int[][] result = new int[rowEnd - rowStart][columnEnd - columnStart];
        int m = 0;
        for (int i = rowStart; i < rowEnd; i++) {
            int n = 0;
            for (int j = columnStart; j < columnEnd; j++) {
                result[m][n] = cells[i][j];
                n++;
            }
            m++;
        }
        return result;
    }

    public static int[][] expand(int[][] cells){
        int[][] result = new int[cells.length + 2][cells[0].length + 2];
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                if(i == 0 || j == 0 || i == result.length - 1 || j == result[i].length - 1){
                    result[i][j] = 0;
                }else{
                    result[i][j] = cells[i - 1][j - 1];
                }
            }
        }
        return result;
    }

    public static int[][] crop(int[][] cells){
        int numRowsToCropInit = canCropInitRow(cells);
        int numRowsToCropEnd = canCropEndRow(cells);
        int numColumnsToCropInit = canCropInitColumn(cells);
        int numColumnsToCropEnd = canCropEndColumn(cells);
        cells = deepCopy(cells,
                numRowsToCropInit, cells.length - numRowsToCropEnd,
                numColumnsToCropInit, cells[0].length - numColumnsToCropEnd);
        return cells;
    }

    public static int canCropEndRow(int[][] cells) {
        int i = cells.length - 1;
        int j = 0;
        int count = 0;
        int numRowsToCrop = 0;
        while(count == 0 && i >= 0){
            j = 0;
            while(count == 0 && j < cells[0].length){
                count += cells[i][j++];
            }
            i--;
            numRowsToCrop++;
        }
        return numRowsToCrop - 1;
    }

    public static int canCropInitRow(int[][] cells) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(count == 0 && i < cells.length){
            j = 0;
            while(count == 0 && j < cells[0].length){
                count += cells[i][j++];
            }
            i++;
        }
        return i - 1;
    }

    public static int canCropEndColumn(int[][] cells) {
        int i = 0;
        int j = cells[0].length - 1;
        int count = 0;
        int numColumnsToCrop = 0;
        while(count == 0 && j >= 0){
            i = 0;
            while(count == 0 && i < cells.length){
                count += cells[i++][j];
            }
            j--;
            numColumnsToCrop++;
        }
        return numColumnsToCrop - 1;
    }

    public static int canCropInitColumn(int[][] cells) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(count == 0 && j < cells[0].length){
            i = 0;
            while(count == 0 && i < cells.length){
                count += cells[i++][j];
            }
            j++;
        }
        return j - 1;
    }

    private static int checkCell(int[][] cells, int i, int j) {
        int state = cells[i][j];
        int count = 0;
        int initI = i == 0 ? 0 : i - 1;
        int endI = i == cells.length - 1 ? cells.length - 1 : i + 1;
        int initJ = j == 0 ? 0 : j - 1;
        int endJ = j == cells[i].length - 1 ? cells[i].length - 1 : j + 1;
        for(int n = initI; n <= endI; n++){
            for(int m = initJ; m <= endJ; m++){
                count += cells[n][m];
            }
        }
        int result = 0;
        count -= state;

        if(count == 3){
            result = 1;
        }else if(state == 1 && count == 2){
            result = 1;
        }
        System.out.println("coordX: " + i + " coordY: " + j + " state: " + state + " count: " + count + " result: " + result);
        return result;
    }

}
