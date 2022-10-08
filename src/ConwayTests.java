import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ConwayTests {

    @Test
    public void conwayLifeTest() {
        int[][][] gliders = {
                        {{1,0,0},
                         {0,1,1},
                         {1,1,0}},
                        {{0,1,0},
                         {0,0,1},
                         {1,1,1}}
        };
        System.out.println("Glider");
        //LifeDebug.print(gliders[0]);
        int[][] res = ConwayLife.conwayLife(gliders[0], 1);
        Utilities.printArray(res);
        Utilities.printArray(gliders[1]);
        assertTrue(Arrays.deepEquals(res, gliders[1]));
    }

    @Test
    public void conwayLifeTest2() {
        int[][][] gliders = {
                        {{1,0,0},
                         {0,1,1},
                         {1,1,0}},
                        {{1,0,1},
                         {0,1,1},
                         {0,1,0}}
        };
        System.out.println("Glider");
        //LifeDebug.print(gliders[0]);
        int[][] res = ConwayLife.conwayLife(gliders[0], 2);
        Utilities.printArray(res);
        Utilities.printArray(gliders[1]);
        assertTrue(Arrays.deepEquals(res, gliders[1]));
    }

    @Test
    public void deepCopyTest(){
        int[][][] gliders = {
                        {{0,0,0},
                        {0,1,1},
                        {0,1,0}},
                        {{0,1,1},
                        {0,1,0}}
        };
        int[][] res = ConwayLife.deepCopy(gliders[0], 1, gliders[0].length, 0, gliders[0][0].length);
        Utilities.printArray(res);
        assertTrue(Arrays.deepEquals(res, gliders[1]));

        int[][][] gliders2 = {
                {{0,0,0},
                        {0,1,1},
                        {0,1,0}},
                {{0,0},
                        {1,1},
                        {1,0}}
        };
        int[][] res2 = ConwayLife.deepCopy(gliders2[0], 0, gliders2[0].length, 1, gliders2[0][0].length);
        Utilities.printArray(res2);
        assertTrue(Arrays.deepEquals(res2, gliders2[1]));

        int[][][] gliders3 = {
                        {{0,0,0,0},
                         {0,0,1,0},
                         {0,0,1,0},
                         {0,0,0,0}},
                        {{0,1},
                         {0,1}}
        };
        int[][] res3 = ConwayLife.deepCopy(gliders3[0], 1, gliders3[0].length - 1, 1, gliders3[0][0].length - 1);
        Utilities.printArray(res3);
        assertTrue(Arrays.deepEquals(res3, gliders3[1]));
    }

    @Test
    public void canCropInitRowTest() {
        int[][] gliders = {{0, 0, 0},
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 1, 0}};
        int res = ConwayLife.canCropInitRow(gliders);
        assertTrue(2 == res);
    }

    @Test
    public void canCropInitColumnTest() {
        int[][] gliders = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 1},
                {0, 0, 0}};
        int res = ConwayLife.canCropInitColumn(gliders);
        assertTrue(2 == res);
    }

    @Test
    public void canCropEndRowTest() {
        int[][] gliders = {{1, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}};
        int res = ConwayLife.canCropEndRow(gliders);
        assertTrue(2 == res);
    }

    @Test
    public void canCropEndColumnTest() {
        int[][] gliders = {{1, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        int res = ConwayLife.canCropEndColumn(gliders);
        assertTrue(2 == res);
    }

    @Test
    public void cropTest() {
        int[][] gliders =  {{0, 0, 0, 0, 0},
                            {0, 1, 0, 0, 0},
                            {0, 0, 1, 0, 0},
                            {0, 0, 0, 1, 0},
                            {0, 0, 0, 0, 0}};
        int [][] resultOk = {{1, 0, 0},
                             {0, 1, 0},
                             {0, 0, 1}};
        int[][] res = ConwayLife.crop(gliders);
        Utilities.printArray(res);
        assertTrue(Arrays.deepEquals(resultOk, res));
    }


}
