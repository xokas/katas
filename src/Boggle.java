import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boggle {

    private final char[][] board;
    private final String word;

    private Set<String> way = new HashSet<>();

    public Boggle(final char[][] board, final String word) {
        this.board = board;
        this.word = word;
    }

    public boolean check() {
        boolean result = false;

        int i = 0;
        while(!result && i < board.length){
            int j = 0;
            while(!result && j < board.length){
                if(board[i][j] == word.charAt(0)) {
                    if(word.length() == 1){
                        result = true;
                    }else {
                        result = check(word, 1, i, j);
                    }
                }
                j++;
            }
            i++;
        }

        return result;
    }

    private boolean check(String word, int index, int x, int y) {
        way.add(x + "" + y);
        boolean found = false;
        int i = x - 1;
        while(!found && i <= x + 1 && index < word.length()){
            if (i >= 0 && i < board.length) {
                int j = y - 1;
                while (!found && j <= y + 1 && index < word.length()) {
                    if(j >= 0 && j < board[0].length){
                        if(word.charAt(index) == board[i][j] && !way.contains(i + "" + j)){
                            if(index + 1 == word.length()){
                                found = true;
                            }else{
                                found = this.check(word, index + 1, i, j);
                            }
                        }
                    }
                    j++;
                }
            }
            i++;
        }

        if(!found){
            way.remove(x + "" + y);
        }

        return found;
    }
}
