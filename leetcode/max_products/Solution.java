public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] sample0 = new int[0];
        System.out.println(s.maxProduct(sample0) == 0);

        int[] sample1 = new int[]{2, 3, -2, 4};
        System.out.println(s.maxProduct(sample1) == 6);

        int[] sample2 = new int[]{2, 0, 3, -2, 4};
        System.out.println(s.maxProduct(sample2) == 4);

        int[] sample3 = new int[]{0, 2, 3, -2, 4};
        System.out.println(s.maxProduct(sample3) == 6);

        int[] sample4 = new int[]{0, 2, 0, 4, 3, -2, 4, 0};
        System.out.println(s.maxProduct(sample4) == 12);

        int[] sample5 = new int[]{0, 2, -2, 2, -2, 2, 0};
        System.out.println(s.maxProduct(sample5) == 32);

        int[] sample6 = new int[]{0, 2, -2, 2, 2, 0};
        System.out.println(s.maxProduct(sample6) == 4);

        int[] sample7 = new int[]{2, -5, -2, -4, 3};
        System.out.println(s.maxProduct(sample7) == 24);
    }

    public int maxProduct(int[] A) {
        int length = A.length;
        if (length < 1) {
            return 0;
        }

        int minProduct  = A[0];
        int maxProduct  = A[0];
        int finalMax    = A[0];

        for (int i = 1; i < length; i ++) {
            int min = Math.min(A[i] * minProduct, A[i] * maxProduct);
            int max = Math.max(A[i] * minProduct, A[i] * maxProduct);

            minProduct = Math.min(A[i], min);
            maxProduct = Math.max(A[i], max);

            finalMax = Math.max(finalMax, maxProduct);
        }

        return finalMax;
    }
}
