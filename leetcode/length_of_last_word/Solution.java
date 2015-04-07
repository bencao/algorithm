public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("abc"));
        System.out.println(s.lengthOfLastWord("abc "));
        System.out.println(s.lengthOfLastWord("abc "));
        System.out.println(s.lengthOfLastWord("da abc "));
        System.out.println(s.lengthOfLastWord(" da abc "));
        System.out.println(s.lengthOfLastWord("       "));
        System.out.println(s.lengthOfLastWord("b   a    "));
        System.out.println(s.lengthOfLastWord("b       "));
    }

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int lastWordStart = -1;
        int lastWordEnd = -1;
        for (int i = 0; i < chars.length; i ++) {
            if (i > 0 && chars[i] == ' ' && chars[i - 1] != ' ') {
                lastWordEnd = i - 1;
            }
            if (chars[i] != ' ' && i == chars.length - 1) {
                lastWordEnd = i;
            }
            if (i == 0 && chars[i] != ' ') {
                lastWordStart = 0;
            }
            if (i > 0 && chars[i] != ' ' && chars[i - 1] == ' ') {
                lastWordStart = i;
            }
        }
        if (lastWordStart == -1) {
            return 0;
        } else {
            return lastWordEnd - lastWordStart + 1;
        }
    }
}
