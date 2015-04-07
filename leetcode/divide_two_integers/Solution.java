import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(456, 1) == 456);
        System.out.println(s.divide(Integer.MAX_VALUE, 1) == Integer.MAX_VALUE);
        System.out.println(s.divide(Integer.MIN_VALUE, 1) == Integer.MIN_VALUE);
        System.out.println(s.divide(-32, -4) == 8);
        System.out.println(s.divide(-32, 8) == -4);
        System.out.println(s.divide(-32, 5) == -6);
        System.out.println(s.divide(32, -8) == -4);
        System.out.println(s.divide(32, -5) == -6);
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        if (dividend < 0 && divisor < 0) {
            if (dividend == Integer.MIN_VALUE) {
                int result = divide(-(dividend - divisor), -divisor);
                return (result == Integer.MAX_VALUE) ? Integer.MAX_VALUE : result + 1;
            } else {
                return divide(-dividend, -divisor);
            }
        } else if (dividend < 0) {
            if (dividend == Integer.MIN_VALUE) {
                return -divide(-(dividend + divisor), divisor) - 1;
            } else {
                return -divide(-dividend, divisor);
            }
        } else if (divisor < 0) {
            return -divide(dividend, -divisor);
        } else {
            LinkedList<Integer> divisors = new LinkedList<Integer>();
            divisors.add(divisor);
            while (divisors.getLast() <= Integer.MAX_VALUE / 2) {
                divisors.add(divisors.getLast() * 2);
            }
            int result = 0;
            for (int index = divisors.size() - 1; index >= 0; index--) {
                if (dividend >= divisors.get(index)) {
                    dividend -= divisors.get(index);
                    result += Math.pow(2, index);
                } else {
                    continue;
                }
            }
            return result;
    }
}
