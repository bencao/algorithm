public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = new int[]{8,3,6,2,8,8,8,4,2,0,7,2,9,4,9};

        System.out.println(s.maxProfit(prices));
        System.out.println(s.oneTransactionMax(prices, 0, 8));
        System.out.println(s.oneTransactionMax(prices, 9, prices.length - 1));

    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        return Math.max(oneTransactionMax(prices), twoTransactionMax(prices));
    }

    public int oneTransactionMax(int[] prices, int start, int end) {
        int min = prices[start];
        int max = 0;
        for (int i = start + 1; i <= end; i ++) {
            max = Math.max(max, prices[i] - min);
            if (prices[i] < min) { min = prices[i]; }
        }
        return max;
    }

    public int oneTransactionMax(int[] prices) {
        return oneTransactionMax(prices, 0, prices.length - 1);
    }

    public int twoTransactionMax(int[] prices) {
        if (prices.length < 4) {
            return oneTransactionMax(prices);
        }
        int max = 0;
        for (int i = 1; i < prices.length - 1; i ++) {
            if (prices[i - 1] <= prices[i] && prices[i + 1] < prices[i]) {
                max = Math.max(max,
                    oneTransactionMax(prices, 0, i) +
                    oneTransactionMax(prices, i + 1, prices.length - 1)
                );
            }
        }
        return Math.max(max, oneTransactionMax(prices, 0, prices.length - 1));
    }
}
