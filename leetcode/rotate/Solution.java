public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(m1);
        s.rotate(m1);
        print(m1);

        int[][] m2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        print(m2);
        s.rotate(m2);
        print(m2);

        int[][] m3 = {};
        print(m3);
        s.rotate(m3);
        print(m3);

        int[][] m4 = {{1}};
        print(m4);
        s.rotate(m4);
        print(m4);
    }

    public static void print(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        System.out.println();
        for (int i = 0; i < matrix.length; i ++) {
            int[] line = matrix[i];
            for (int j = 0; j < line.length; j ++) {
                System.out.print(matrix[i][j]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        diagonalExchange(matrix, n);
        yAxisExchange(matrix, n);
    }

    public void diagonalExchange(int[][] matrix, int n) {
        for (int y = 0; y < n - 1; y ++) {
            for (int x = 0; x < n - y; x ++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[][];

            }
        }

    }

    public void yAxisExchange(int[][] matrix) {

    }
}
