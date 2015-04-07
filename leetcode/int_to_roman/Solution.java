public class Solution {
    public static void main(String[] args) {
       Solution s = new Solution();
       System.out.println(s.intToRoman(1).equals("I"));
       System.out.println(s.intToRoman(2).equals("II"));
       System.out.println(s.intToRoman(3).equals("III"));
       System.out.println(s.intToRoman(4).equals("IV"));
       System.out.println(s.intToRoman(5).equals("V"));
       System.out.println(s.intToRoman(6).equals("VI"));
       System.out.println(s.intToRoman(7).equals("VII"));
       System.out.println(s.intToRoman(8).equals("VIII"));
       System.out.println(s.intToRoman(9).equals("IX"));
       System.out.println(s.intToRoman(10).equals("X"));
       System.out.println(s.intToRoman(1234).equals("MCCXXXIV"));
    }

    public static final String[] UNITS = new String[] {
        "I", "V", "X", "L", "C", "D", "M"
    };

    public static String getUnit(int index) {
        if (index >= UNITS.length) {
            return "";
        } else {
            return UNITS[index];
        }
    }

    public String intToRoman(int num) {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < 4; i ++) {
            buffer.insert(0, digitToRoman(num % 10, i));
            num = num / 10;
        }

        return buffer.toString();
    }

    public String digitToRoman(int digit, int digitIndex) {
        String one  = getUnit(2 * digitIndex);
        String five = getUnit(2 * digitIndex + 1);
        String ten  = getUnit(2 * digitIndex + 2);

        switch (digit) {
            case 0: return "";
            case 1: return one;
            case 2: return one + one;
            case 3: return one + one + one;
            case 4: return one + five;
            case 5: return five;
            case 6: return five + one;
            case 7: return five + one + one;
            case 8: return five + one + one + one;
            case 9: return one + ten;
        }
        return "";
    }
}
