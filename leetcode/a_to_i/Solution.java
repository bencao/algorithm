import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.atoi("  abc ") == 0);
        System.out.println(s.atoi("123") == 123);
        System.out.println(s.atoi("  123 ") == 123);
        System.out.println(s.atoi("  123abc ") == 123);
        System.out.println(s.atoi("-123") == -123);
        System.out.println(s.atoi("  -123 ") == -123);
        System.out.println(s.atoi("  -123abc ") == -123);
        System.out.println(s.atoi("-2147483647") == -2147483647);
        System.out.println(s.atoi("-2147483648") == -2147483648);
        System.out.println(s.atoi("-12147483648") == -2147483648);
        System.out.println(s.atoi("2147483647") == 2147483647);
        System.out.println(s.atoi("2147483648") == 2147483647);
        System.out.println(s.atoi("12147483648") == 2147483647);
        System.out.println(s.atoi("+-2") == 0);

        System.out.println(s.atoi(" b11228552307") == 0);
    }


    public int atoi(String str) {
        if (str == null) {
            return 0;
        }

        char[] chars = purge(str);

        if (chars.length == 0) {
            return 0;
        }

        if (chars[0] == '-') {
            return atoiNegative(Arrays.copyOfRange(chars, 1, chars.length));
        } else if (chars[0] == '+') {
            return atoiPositive(Arrays.copyOfRange(chars, 1, chars.length));
        } else {
            return atoiPositive(chars);
        }
    }

    public int atoiNegative(char[] chars)  {
        long result   = 0;
        long multiple = 1;

        for (int i = chars.length - 1; i >= 0; i --) {
            if (result - Integer.MIN_VALUE <= 0L) {
                break;
            }

            result -= (chars[i] - '0') * multiple;
            multiple *= 10;
        }

        if (result - Integer.MIN_VALUE <= 0L) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }

    public int atoiPositive(char[] chars) {
        long result   = 0;
        long multiple = 1;

        for (int i = chars.length - 1; i >= 0; i --) {
            if (result - Integer.MAX_VALUE >= 0L) {
               break;
            }

            result += (chars[i] - '0') * multiple;
            multiple *= 10;
        }

        if (result - Integer.MAX_VALUE >= 0L) {
            return Integer.MAX_VALUE;
        } else {
            return (int) result;
        }
    }

    public char[] purge(String str) {
        char[] chars = str.trim().toCharArray();
        int start    = -1;
        int end      = chars.length;
        for (int i = 0; i < chars.length; i ++) {
            char c = chars[i];
            if (start == -1) {
                if (c == '-' || c == '+' || (c >= '0' && c <= '9')) {
                    start = i;
                } else {
                    break;
                }
            } else if (c < '0' || c > '9') {
                end = i;
                break;
            }
        }
        if (start == -1) {
            return new char[0];
        }
        return Arrays.copyOfRange(chars, start, end);
    }
}
