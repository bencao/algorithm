public class Solution {
    public static void main(String[] args) {
       Solution s = new Solution();
       System.out.println(s.romanToInt("I") == 1);
       System.out.println(s.romanToInt("II") == 2);
       System.out.println(s.romanToInt("III") == 3);
       System.out.println(s.romanToInt("IV") == 4);
       System.out.println(s.romanToInt("V") == 5);
       System.out.println(s.romanToInt("VI") == 6);
       System.out.println(s.romanToInt("VII") == 7);
       System.out.println(s.romanToInt("VIII") == 8);
       System.out.println(s.romanToInt("IX") == 9);
       System.out.println(s.romanToInt("X") == 10);
       System.out.println(s.romanToInt("MCCXXXIV") == 1234);
    }

    public static int charToValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        return 0;
    }

    public static int adjustments(String s) {
        switch (s) {
            case "IV":
            case "IX": return -2;
            case "XL":
            case "XC": return -20;
            case "CD":
            case "CM": return -200;
        }

        return 0;
    }

    public static final String[] specials = new String[] {
        "IV", "IX", "XL", "XC", "CD", "CM"
    };

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int total = 0;
        for (char c : chars) {
            total += charToValue(c);
        }
        for (int i = 0; i < specials.length; i ++) {
            if (s.indexOf(specials[i]) != -1) {
                total += adjustments(specials[i]);
            }
        }
        return total;
    }

}
