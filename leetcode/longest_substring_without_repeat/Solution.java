import java.util.Map;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLongestSubstring("abc") == 3);
        System.out.println(s.lengthOfLongestSubstring("abca") == 3);
        System.out.println(s.lengthOfLongestSubstring("abaca") == 3);
        System.out.println(s.lengthOfLongestSubstring("abba") == 2);
        System.out.println(s.lengthOfLongestSubstring("aa") == 1);
        System.out.println(s.lengthOfLongestSubstring("a") == 1);
        System.out.println(s.lengthOfLongestSubstring("") == 0);
        System.out.println(s.lengthOfLongestSubstring("abcdefgctyp") == 8);
        System.out.println(s.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco") == 12);
        System.out.println(s.lengthOfLongestSubstring("abcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcdeabcdebabcde"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength   = 0;
        int length = 0;
        for (int i = 0; i < chars.length; i ++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                maxLength = Math.max(maxLength, length);
                int previousIndex = map.get(c);
                for (int j = i - length; j < previousIndex; j ++) {
                    map.remove(chars[j]);
                }
                map.put(c, i);
                length = i - previousIndex;
            } else {
                length ++;
                map.put(c, i);
            }
        }
        return Math.max(maxLength, length);
    }
}
