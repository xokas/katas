import java.util.ArrayList;
import java.util.List;

public class ThreeDigitsSum {

    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        List<Long> result = new ArrayList<Long>();
        int sumLocal = 0;
        int numLocal = 0;

        long max = getMax(sumDigits, numDigits);
        if (max != 0) {
            List<String> list = new ArrayList<>();
            long numCombinations = getCombinations(numDigits, sumDigits, list);
            result.add(numCombinations);
            result.add(Long.parseLong(list.get(0)));
            result.add(max);
        }
        return result;
    }

    static long getCombinations(int n, int sum, List<String> list) {
        char[] a = new char[n];
        return getCombinations(1, n, sum, list, a, 0);
    }

    static long getCombinations(int init, int n, int sum, List<String> list, char[] out, int index) {
            long result = 0L;

            if (index > n || sum < 0) {
                return 0;
            }

            if(index == n && sum > 0){
                return 0;
            }

            if (index == n && sum == 0) {
                list.add(new String(out));
                return 1;
            }

            for (int i = init; i <= 9; i++){
                out[index] = (char)(i + '0');
                result += getCombinations(i, n, sum - i, list, out, index + 1);
            }
            return result;
    }

    static long getMin(int n, int sumDigits, int numDigits){
        if(numDigits == 1){
            return sumDigits;
        }
        long min = 0;
        for(int i = n; i < 10; i++){
            if((sumDigits - i) / (numDigits) < 10 && (sumDigits - i) % (numDigits) == 0){
                min = i * (long) Math.pow(10, numDigits - 1);
                min += getMin(i,sumDigits - i, numDigits - 1);
                break;
            }
        }
        return min;
    }

    static long getMax(int sumDigits, int numDigits){
        if(numDigits == 1){
            return sumDigits;
        }

        int n = sumDigits / numDigits;
        if(n > 10){
            return 0;
        }
        long max = n * (long) Math.pow(10, numDigits - 1);
        max += getMax(sumDigits - n, numDigits -1);

        return max;
    }

}
