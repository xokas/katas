import java.util.*;

public class BurrowsWheeler {

    public static BWT encode(String s) {
        List<String> matrix = createMatrix(s);
        int position = 0;
        int i = 0;
        StringBuilder sCode = new StringBuilder("");
        for(String row : matrix){
            sCode.append(row.substring(row.length() - 1));
            if(row.equals(s)){
                position = i;
            }
            i++;
        }
        return new BWT(sCode.toString(), position);          // new BWT("stuff", -1);
    }

    static List<String> createMatrix(String s) {
        List<String> matrix = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            s = shiftString(s);
            matrix.add(s);
        }
        Collections.sort(matrix);
        return matrix;
    }

    static String shiftString(String s){
        char[] result = new char[s.length()];
        char[] sChar = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
            result[i] = sChar[i - 1];
        }
        result[0] = sChar[s.length() - 1];
        return new String(result);
    }

    public static String decode(String s, int n) {
        class CharIndex implements Comparable<CharIndex>{
            public char c;
            public int i;
            public CharIndex(char c, int i){
                this.c = c;
                this.i = i;
            }
            public String toString(){
                return this.c + " " + this.i;
            }

            @Override
            public int compareTo(CharIndex ci) {
                return Character.compare(this.c, ci.c) ;
            }
        }

        if(s == "") return "";

        CharIndex[] arr = new CharIndex[s.length()];
        int i = 0;
        for(char c : s.toCharArray()){
            arr[i] = new CharIndex(c, i);
            i++;
        }

        Arrays.sort(arr);

        String answer = ""+arr[n].c;
        int next = arr[n].i;
        while(next != n){
            answer = answer + arr[next].c;
            next = arr[next].i;
        }
        return answer;
    }


}
