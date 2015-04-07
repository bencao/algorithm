public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] sample1 = new int[]{0};
        System.out.println(s.jump(sample1) == 0);

        int[] sample2 = new int[]{2, 3, 1, 1, 4};
        System.out.println(s.jump(sample2) == 2);

        int[] sample3 = new int[]{1, 1, 1, 1, 1, 1};
        System.out.println(s.jump(sample3) == 5);

        int[] sample4 = new int[]{65535, 1, 1, 1, 1, 1};
        System.out.println(s.jump(sample4) == 1);

        int[] sample5 = new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(s.jump(sample5));
    }

    public int jump(int[] A) {
        int length = A.length;

        if (length == 1) {
            return 0;
        }

        int index = 0;
        int steps = 1;
        while (index + A[index] < A.length - 1) {
            index = bestChoice(A, index);
            steps ++;
        }
        return steps;
    }

    public int bestChoice(int[] A, int index) {
        int max = index + 1 + A[index + 1];
        int maxIndex = index + 1;
        for (int i = index + 2; i <= index + A[index]; i ++) {
            if (A[i] > 0 && i + A[i] > max) {
                max = i + A[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
