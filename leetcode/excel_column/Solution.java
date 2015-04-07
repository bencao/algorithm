public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.titleToNumber("A"));
        System.out.println(s.titleToNumber("Z"));
        System.out.println(s.titleToNumber("AA"));
        System.out.println(s.titleToNumber("AB"));
        System.out.println(s.titleToNumber("ZZ"));
        System.out.println(s.titleToNumber("AAA"));
        System.out.println(s.titleToNumber("ZZZ"));
    }

    public int titleToNumber(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); i ++) {
            number = number * 26 + charToInt(s.charAt(i));
        }
        return number;
    }

    public int charToInt(char c) {
        return c - 'A' + 1;
    }
}
