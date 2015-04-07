import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.partition("a"));
        System.out.println(s.partition("aa"));
        System.out.println(s.partition("ab"));
        System.out.println(s.partition("bab"));
        System.out.println(s.partition("aaa"));
        System.out.println(s.partition("aab"));
        System.out.println(s.partition("aaaaa"));
        System.out.println(s.partition("aaaaaaaa"));
        System.out.println(s.partition("amanaplanacanalpanama"));
        System.out.println(s.partition("kwtbjmsjvbrwriqwxadwnufplszhqccayvdhhvscxjaqsrmrrqngmuvxnugdzjfxeihogzsdjtvdmkudckjoggltcuybddbjoizu"));
    }

    List<List<String>> solutions = null;
    List<String> currentSolution = null;

    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        int length   = chars.length;

        solutions       = new LinkedList<List<String>>();
        currentSolution = new LinkedList<String>();

        partitionRemain(chars, 0, length);

        return solutions;
    }

    private void partitionRemain(char[] chars, int start, int end) {
        if (start == end) {
            solutions.add(currentSolution);
            return;
        }

        for (int i = start + 1; i <= end; i++) {
            if (isPalindrome(chars, start, i)) {
                List<String> originSolution = currentSolution;
                currentSolution = new LinkedList<String>(originSolution);
                currentSolution.add(charsToString(chars, start, i));
                partitionRemain(chars, i, end);
                currentSolution = originSolution;
            }
        }
    }

    private boolean isPalindrome(char[] chars, int start, int end) {
        int j = end - 1;
        for (int i = start; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    private String charsToString(char[] chars, int start, int end) {
        StringBuffer sb = new StringBuffer();
        for (int i = start; i < end; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
