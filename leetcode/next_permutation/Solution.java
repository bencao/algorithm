public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] sample1 = new int[] { 1, 2, 3 };
        s.nextPermutation(sample1);
        print(sample1);

        int[] sample2 = new int[] { 2, 2, 0, 4, 3, 1 };
        s.nextPermutation(sample2);
        print(sample2);
    }

    public static void print(int[] array) {
        for (int i : array) {
            System.out.print(i);
        }
        System.out.println();
    }

    public void nextPermutation(int[] num) {
        if (num.length < 2) {
            return;
        }

        int k = -1;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                k = i - 1;
                break;
            }
        }

        if (k == -1) {
            reverse(num, 0, num.length);
            return;
        }

        System.out.println(k);

        for (int j = num.length - 1; j > k; j--) {
            if (num[j] > num[k]) {
                System.out.println(j);
                // swap j, k
                int temp = num[j];
                num[j] = num[k];
                num[k] = temp;

                reverse(num, k + 1, num.length);
                break;
            }
        }
    }

    public void reverse(int[] array, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
