import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        // s.restoreIpAddresses("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        // s.restoreIpAddresses("0000");
        s.restoreIpAddresses("010010");
    }

    List<String> solutions;

    public List<String> restoreIpAddresses(String s) {
        // split into 4 numbers, each smaller or equal 255

        // edge cases
        // 1. s is empty
        // 2. prefixing 0s case
        // 3. shorter than 4 digits
        // 4. start with 0 case

        // naive way
        // choose 3 index, and validate 4 areas are valid
        // problem:
        solutions = new LinkedList<String>();
        char[] digits = s.toCharArray();
        trySplit(digits, "", 4, 0);
        return solutions;
    }

    private void trySplit(char[] digits, String prefix, int remainParts, int currentIndex) {
        if (remainParts == 0) {
            if (currentIndex == digits.length) {
                System.out.println(prefix);
                solutions.add(prefix);
            }
            return;
        }

        if (currentIndex == digits.length && remainParts > 0) {
            return;
        }

        int part = 0;
        for (int i = currentIndex; i < digits.length; i++) {
            if (part == 0 && i > currentIndex) {
                return;
            }
            part = part * 10 + (digits[i] - '0');
            if (part > 255) {
                return;
            }
            if (prefix.length() == 0) {
                trySplit(digits, Integer.toString(part), remainParts - 1, i + 1);
            } else {
                trySplit(digits, prefix + "." + Integer.toString(part), remainParts - 1, i + 1);
            }
        }
    }
}
