import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Kata {

    public static void main(String[] args) {
        // countVowels
        /*System.out.println(findNextSquare(122));
        System.out.println(findNextSquare(121));
        System.out.println(findNextSquare(144));*/

        System.out.println(arrayDiff(new int [] {1,2}, new int[] {1}));
        System.out.println(arrayDiff(new int [] {1,2}, new int[] {1}));
        
    }

    private static void countVowels(){
        System.out.println("Hello world!");
        String str = "aeiouddd";
        int count = 0;
        for(char c : str.toCharArray()){
            if ("aeiou".indexOf(c) != -1){
                count++;
            }
        }
        System.out.println(count);
    }

    public static long findNextSquare(long sq) {
        long result = -1;
        long r = (long) Math.sqrt(sq);
        if(r * r == sq){
            r++;
            result = r * r;
        }
        return result;
    }

    public static boolean isTriangle(int a, int b, int c){
        int[] sides = {a, b, c};
        Arrays.sort(sides);

        return sides[2] < sides[1] + sides[0];
    }

    public static int[] arrayDiff(int[] a, int[] b) {

        if (b.length == 0){
            return a;
        }else if (a.length > 0){
            List result = new ArrayList<Integer>();
            for (int elementA : a){
                boolean found = false;
                int j = 0;
                do{
                    int elementB = b[j++];
                    if(elementA == elementB){
                        found = true;
                    }
                }while (!found && j < b.length);
                if(!found){
                    result.add(elementA);
                }
            }
            return result.stream().mapToInt(i-> (int) i).toArray();
        }
        return new int[] {};
    }

    public static String whoLikesIt(String... names) {
        StringBuilder result = new StringBuilder("");
        int i = 0;
        if(names.length <= 1){
            if(names.length == 0){
                result.append("no one");
            }else{
                result.append(names[0]);
            }
            result.append(" likes this");
        } else {
            result.append(names[i++]);
            if (names.length > 2) {
                result.append(", ");
                result.append(names[i++]);
            }
            result.append(" and ");
            if (names.length > 3) {
                result.append(String.valueOf(names.length - 2));
                result.append(" others");
            } else {
                result.append(names[i++]);
            }
            result.append(" like this");
        }
        return result.toString();
    }

    public static String disemvowel(String s) {
        return s.replaceAll("[aeiouAEIOU]","");
    }

    public static int findIt(int[] ints) {
        int result = -1;
        Map<Integer, Long> frequencyMap =  Arrays.stream(ints).boxed().collect(Collectors.groupingBy(
                Function.identity(),
                HashMap::new, // can be skipped
                Collectors.counting()));
        result = frequencyMap.entrySet().stream().filter(a -> a.getValue() % 2 == 1).findAny().get().getKey().intValue();

        return result;
    }

    public static int[] digitize(long n) {
        return new StringBuilder().append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static String removeChar(String str) {
        return str.substring(1, str.length() -1);
    }

    public static int findShort(String s) {
        int result = s.length();
        for(String str : s.split(" ")){
            result = str.length() < result ? str.length() : result;
        }
        return result;
    }

    public static int findShortStream(String s){
        return Stream.of(s.split(" ")).mapToInt(String::length).min().getAsInt();
    }

    public static boolean tenMinWalk(char[] walk) {
        boolean result = false;

        if (walk.length == 10){
            int[] coords = {0,0};
            for(char c : walk) {
                switch (c){
                    case 'n':
                        coords[0]++;
                        break;
                    case 's':
                        coords[0]--;
                        break;
                    case 'e':
                        coords[1]++;
                        break;
                    case 'w':
                        coords[1]--;
                        break;
                }
            }
            result = coords[0] == 0 && coords[1] == 0;
        }

        return result;
    }


}
