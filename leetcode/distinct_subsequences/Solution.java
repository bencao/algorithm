public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDistinct("rabbbit", "rabbit"));
        System.out.println(s.numDistinct("a", "a") == 1);
        System.out.println(s.numDistinct("acdcd", "acd") == 3);
        System.out.println(s.numDistinct("rab", "rabbit"));
    }

    public int numDistinct(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int m = s.length;
        int n = t.length;

        int[][] memo = new int[m][n];

        char firstChar = t[0];
        memo[0][0] = ((s[0] == firstChar) ? 1 : 0);

        for (int i = 1; i < m; i ++) {
            memo[i][0] = memo[i - 1][0];
            if (s[i] == firstChar) {
                memo[i][0] += 1;
            }
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j <= i && j < n; j ++) {
                if (s[i] == t[j]) {
                    memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }

        return memo[m - 1][n - 1];
    }
}
