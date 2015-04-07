import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestPalindrome("a").equals("a"));
        System.out.println(s.longestPalindrome("ab").equals("a"));
        System.out.println(s.longestPalindrome("abb").equals("bb"));
        System.out.println(s.longestPalindrome("abba").equals("abba"));
        System.out.println(s.longestPalindrome("abcba").equals("abcba"));
        System.out.println(s.longestPalindrome("cabba").equals("abba"));
        System.out.println(s.longestPalindrome("abbac").equals("abba"));
        System.out.println(s.longestPalindrome("cabbac").equals("cabbac"));
        System.out.println(s.longestPalindrome("cabb").equals("bb"));
        System.out.println(s.longestPalindrome("cabba").equals("abba"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int max     = 0;
        int leftMax = -1;
        int rightMax = -1;
        for (int center = 0; center < chars.length; center ++) {
            int range = maxRangeForOdd(chars, center);
            int length = 2 * range + 1;
            if (length > max) {
                max      = length;
                leftMax  = center - range;
                rightMax = center + range;
            }
        }
        for (int gap = 1; gap < chars.length; gap ++) {
            int range = maxRangeForEven(chars, gap);
            int length = 2 + 2 * range;
            if (length > max) {
                max      = length;
                leftMax  = gap - 1 - range;
                rightMax = gap + range;
            }
        }
        return new String(Arrays.copyOfRange(chars, leftMax, rightMax + 1));
    }

    public int maxRangeForOdd(char[] chars, int center) {
        int left  = center;
        int right = center;
        int range = 0;
        while (left >= 0 && right < chars.length) {
            if (chars[left] == chars[right]) {
                left --;
                right ++;
                range += 1;
            } else {
                break;
            }
        }
        return range - 1;
    }

    public int maxRangeForEven(char[] chars, int gap) {
        int left  = gap - 1;
        int right = gap;
        int range = 0;
        while (left >= 0 && right < chars.length) {
            if (chars[left] == chars[right]) {
                left --;
                right ++;
                range += 1;
            } else {
                break;
            }
        }
        return range - 1;
    }
}
