import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fractionToDecimal(-50, 8).equals("-6.25"));
        System.out.println(s.fractionToDecimal(50, 8).equals("6.25"));
        System.out.println(s.fractionToDecimal(1, 8).equals("0.125"));
        System.out.println(s.fractionToDecimal(7, -12).equals("-0.58(3)"));
        System.out.println(s.fractionToDecimal(1, 10000).equals("0.0001"));
        System.out.println(s.fractionToDecimal(-1, -2147483648));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        long longNumerator = numerator;
        long longDenominator = denominator;

        if (longNumerator < 0 && longDenominator < 0) {
            return fractionToDecimal(-longNumerator, -longDenominator);
        } else if (longNumerator < 0) {
            return "-" + fractionToDecimal(-longNumerator, longDenominator);
        } else if (longDenominator < 0) {
            return "-" + fractionToDecimal(longNumerator, -longDenominator);
        } else {
            return fractionToDecimal(longNumerator, longDenominator);
        }
    }

    public String fractionToDecimal(long numerator, long denominator) {
        long wholeNumber = numerator / denominator;
        long remains = Math.abs(numerator % denominator);

        Map<Long, Integer> remainIndexes = new HashMap<Long, Integer>();

        String wholeNumberPart = Long.toString(wholeNumber);
        StringBuffer fractionalPart = new StringBuffer();

        int currentIndex = 0;
        while (remains > 0) {
            if (remainIndexes.containsKey(remains)) {
                // repeating detected
                fractionalPart.insert((int) remainIndexes.get(remains), '(');
                fractionalPart.append(')');
                break;
            }
            remainIndexes.put(remains, currentIndex++);
            fractionalPart.append(remains * 10L / denominator);
            remains = remains * 10L % denominator;
        }

        if (fractionalPart.length() > 0) {
            return wholeNumberPart + "." + fractionalPart.toString();
        } else {
            return wholeNumberPart;
        }

    }
}

