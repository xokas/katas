import java.util.List;

public class Utilities {
    public static void printArray(int[][] arr){
        for (int i = 0; i<arr.length; i++) {
            for (int j = 0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void printCharArray(char[] arr){
        for (char s : arr) {
            System.out.println(s);
        }
    }

    public static void printIntArray(int[] arr){
        for (int s : arr) {
            System.out.println(s);
        }
    }
    public static void printStringArray(String[] arr){
        for (String s : arr) {
            System.out.println(s);
        }
    }

    public static void printListStringArray(List<String> list){
        for (String s : list) {
            System.out.println(s);
        }
    }
}
