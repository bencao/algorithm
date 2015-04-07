import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] sample0 = new int[] { 1 };
        System.out.println(s.largestNumber(sample0).equals("1"));

        int[] sample1 = new int[] { 1, 2 };
        System.out.println(s.largestNumber(sample1).equals("21"));

        int[] sample2 = new int[] { 9, 34 };
        System.out.println(s.largestNumber(sample2).equals("934"));

        int[] sample3 = new int[] { 9, 34, 35 };
        System.out.println(s.largestNumber(sample3).equals("93534"));

        int[] sample4 = new int[] { 9, 44, 35 };
        System.out.println(s.largestNumber(sample4).equals("94435"));

        int[] sample5 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(s.largestNumber(sample5).equals("987654321"));

        int[] sample6 = new int[] { 2, 3, 1, 6, 4, 5, 7, 8, 9 };
        System.out.println(s.largestNumber(sample6).equals("987654321"));

        int[] sample7 = new int[] { 10, 2 };
        System.out.println(s.largestNumber(sample7).equals("210"));

        int[] sample8 = new int[] { 121, 12 };
        System.out.println(s.largestNumber(sample8).equals("12121"));

        int[] sample9 = new int[] { 0, 0 };
        System.out.println(s.largestNumber(sample9).equals("0"));
    }

    public String largestNumber(int[] num) {
        int[] sortedNum = Arrays.copyOf(num, num.length);
        quickSort(sortedNum, 0, sortedNum.length);

        StringBuffer sb = new StringBuffer();
        boolean trailingHeadZeros = true;
        for (int n : sortedNum) {
            if (trailingHeadZeros && n == 0) {
                continue;
            } else {
                trailingHeadZeros = false;
                sb.append(n);
            }
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }

    public void quickSort(int[] array, int start, int end) {
        if (start + 1 >= end) {
            return;
        }

        int p = partition(array, start, end);
        quickSort(array, start, p);
        quickSort(array, p + 1, end);
    }

    public void print(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(array[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public int partition(int[] array, int start, int end) {
        int flag   = array[end - 1];
        int pLast  = end - 2;
        int pFirst = start;

        while (pFirst <= pLast) {
            if (smallerThan(array[pFirst], flag)) {
                int temp      = array[pLast];
                array[pLast]  = array[pFirst];
                array[pFirst] = temp;
                pLast--;
            } else {
                pFirst++;
            }
        }

        if (smallerThan(array[pFirst], flag)) {
            array[end - 1] = array[pFirst];
            array[pFirst] = flag;
        }

        return pFirst;
    }

    public boolean smallerThan(int a, int b) {
        String aFirst = Integer.toString(a) + Integer.toString(b);
        String bFirst = Integer.toString(b) + Integer.toString(a);

        for (int i = 0; i < aFirst.length(); i++) {
            if (aFirst.charAt(i) == bFirst.charAt(i)) {
                continue;
            }
            return aFirst.charAt(i) < bFirst.charAt(i);
        }
        return false;
    }

}
