public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a1 = {1, 3, 5, 7, 9};
        int[] b1 = {};
        System.out.println(s.findMedianSortedArrays(a1, b1));

        int[] a2 = {};
        int[] b2 = {2, 4, 6, 8, 10};
        System.out.println(s.findMedianSortedArrays(a2, b2));

        int[] a3 = {1, 3, 5, 7, 9};
        int[] b3 = {2, 4, 6, 8, 10};
        System.out.println(s.findMedianSortedArrays(a3, b3));

        int[] a4 = {1, 3, 5, 7, 9};
        int[] b4 = {2};
        System.out.println(s.findMedianSortedArrays(a4, b4));

        int[] a5 = {1};
        int[] b5 = {2};
        System.out.println(s.findMedianSortedArrays(a5, b5));

        int[] a6 = {1, 2};
        int[] b6 = {3};
        System.out.println(s.findMedianSortedArrays(a6, b6));
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int length = A.length + B.length;
        int k = length / 2;
        if (length % 2 == 0) {
            return ((double) (
                    getKBig(A, 0, A.length - 1, B, 0, B.length - 1, k) +
                    getKBig(A, 0, A.length - 1, B, 0, B.length - 1, k + 1)
                ) / 2);
        } else {
            return (double) getKBig(A, 0, A.length - 1, B, 0, B.length - 1, k + 1);
        }
    }

    public int getKBig(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd, int k) {
        // A has no element
        if (aEnd < aStart) {
            return B[bStart + k - 1];
        }

        if (bEnd < bStart) {
            return A[aStart + k - 1];
        }

        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        if (k == 2) {
            if (A[aStart] < B[bStart]) {
                return getKBig(A, aStart + 1, aEnd, B, bStart, bEnd, 1);
            } else {
                return getKBig(A, aStart, aEnd, B, bStart + 1, bEnd, 1);
            }
        }

        int a = Math.min(aEnd - aStart, k/2);
        int b = Math.min(bEnd - bStart, k - 1 - a);

        if (a == 0) {
            if (A[aStart] < B[bStart + k - 2]) {
                return B[bStart + k - 2];
            } else {
                return Math.min(A[aStart], B[bStart + k - 1]);
            }
        }

        if (b == 0) {
            if (B[bStart] < A[aStart + k - 2]) {
                return A[aStart + k - 2];
            } else {
                return Math.min(B[bStart], A[aStart + k - 1]);
            }
        }

        if (A[aStart + a] < B[bStart + b]) {
            return getKBig(A, aStart + a, aEnd, B, bStart, bStart + b, k - a);
        } else {
            return getKBig(A, aStart, aStart + a, B, bStart + b, bEnd, k - b);
        }

    }
}
