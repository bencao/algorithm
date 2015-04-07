import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] board = new char[][] {
            new char[] { 'a', 'b', 'c', 'd' },
            new char[] { 'a', 'b', 'c', 'd' },
            new char[] { 'a', 'b', 'c', 'd' },
            new char[] { 'a', 'b', 'c', 'd' }
        };

        System.out.println(s.exist(board, "a"));
        System.out.println(s.exist(board, "b"));
        System.out.println(s.exist(board, "c"));
        System.out.println(s.exist(board, "d"));

        System.out.println(s.exist(board, "ab"));
        System.out.println(s.exist(board, "aa"));
        System.out.println(!s.exist(board, "ac"));
        System.out.println(!s.exist(board, "ad"));
        System.out.println(s.exist(board, "bb"));
        System.out.println(s.exist(board, "bc"));

        System.out.println(s.exist(board, "aabbccdddd"));
        System.out.println(s.exist(board, "abbbbcd"));

        long start = System.currentTimeMillis();
        char[][] board1 = new char[][] {
            new char[] { 'a', 'a', 'a', 'a' },
            new char[] { 'a', 'a', 'a', 'a' },
            new char[] { 'a', 'a', 'a', 'a' }
        };
        System.out.println(!s.exist(board1, "aaaaaaaaaaab"));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        char[][] board2 = new char[][] {
            new char[] { 'a', 'a'}
        };
        System.out.println(!s.exist(board2, "aaa"));
    }

    public boolean exist(char[][] board, String word) {
        char[] wordChars = word.trim().toCharArray();

        if (wordChars.length == 0) {
            return false;
        }

        Set<Character> boardCharSet = new HashSet<Character>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boardCharSet.add(board[row][col]);
            }
        }

        for (int i = 0; i < wordChars.length; i++) {
            if (!boardCharSet.contains(wordChars[i])) {
                return false;
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                Set<Position> visited = new HashSet<Position>();
                if (scan(board, row, col, wordChars, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private class Position {
        char[][] board;
        int row;
        int col;

        Position(char[][] board, int row, int col) {
            this.board = board;
            this.row   = row;
            this.col   = col;
        }

        public boolean isValid() {
            return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
        }

        public boolean equals(Object o) {
            if (o instanceof Position) {
                Position p = (Position) o;
                return p.row == row && p.col == col;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return row * 13 + col * 17;
        }
    }

    private boolean scan(char[][] board, int row, int col, char[] wordChars, int charIndex, Set<Position> visited) {
        if (board[row][col] != wordChars[charIndex]) {
            return false;
        }

        Position currentPosition = new Position(board, row, col);

        if (visited.contains(currentPosition)) {
            return false;
        }

        if (charIndex == wordChars.length - 1) {
            return true;
        }

        visited.add(currentPosition);

        for (Position nextPosition: validAdjacentPositions(currentPosition)) {
            if (scan(board, nextPosition.row, nextPosition.col, wordChars, charIndex + 1, visited)) {
                return true;
            }
        }

        visited.remove(currentPosition);

        return false;
    }

    private List<Position> validAdjacentPositions(Position p) {
        List<Position> possiblePositions = new LinkedList<Position>();
        possiblePositions.add(new Position(p.board, p.row - 1, p.col)); // UP
        possiblePositions.add(new Position(p.board, p.row, p.col + 1)); // RIGHT
        possiblePositions.add(new Position(p.board, p.row + 1, p.col)); // DOWN
        possiblePositions.add(new Position(p.board, p.row, p.col - 1)); // LEFT
        Iterator<Position> it = possiblePositions.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
        return possiblePositions;
    }
}
