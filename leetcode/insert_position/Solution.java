public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a1 = {1, 2, 3, 4, 5};
        System.out.println(s.searchInsert(a1, 0));
        System.out.println(s.searchInsert(a1, 1));
        System.out.println(s.searchInsert(a1, 2));
        System.out.println(s.searchInsert(a1, 3));
        System.out.println(s.searchInsert(a1, 4));
        System.out.println(s.searchInsert(a1, 5));
        System.out.println(s.searchInsert(a1, 6));
    }

    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = (int)((start + end) / 2);
            if (A[mid] < target) {
                start = mid + 1;
            } else if (A[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }

}
