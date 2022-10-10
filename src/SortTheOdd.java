public class SortTheOdd {

    public static int[] sortArray(int[] array) {
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0) {
                for (int j = i; j < array.length; j++) {
                    if (array[j] % 2 != 0) {
                        if (array[i] > array[j]) {
                            int aux = array[i];
                            array[i] = array[j];
                            array[j] = aux;
                        }
                    }
                }
            }
        }
        Utilities.printIntArray(array);
        return array;
    }
}
