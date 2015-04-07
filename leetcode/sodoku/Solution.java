import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashSet;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        // check 9 blocks to be valid
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                LinkedList<Character> list = new LinkedList<Character>();
                for (int k = i; k < i + 3; k ++) {
                    for (int l = j; l < j + 3; l ++) {
                        list.add(board[k][l]);
                    }
                }
                if (!check(list)) {
                    return false;
                }
            }
        }
        // check 9 rows to be valid
        for (int i = 0; i < 9; i ++) {
            LinkedList<Character> list = new LinkedList<Character>();
            for (int j = 0; j < 9; j ++) {
                list.add(board[i][j]);
            }
            if (!check(list)) {
                return false;
            }
        }
        // check 9 columns to be valid
        for (int j = 0; j < 9; j ++) {
            LinkedList<Character> list = new LinkedList<Character>();
            for (int i = 0; i < 9; i ++) {
                list.add(board[i][j]);
            }
            if (!check(list)) {
                return false;
            }
        }
        return true;
    }

    public boolean check(LinkedList<Character> chars) {
        HashSet<Character> set = new HashSet<Character>();
        Iterator<Character> it = chars.iterator();
        while (it.hasNext()) {
            char c = it.next();
            if (c == '.') {
                continue;
            }
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }
}
