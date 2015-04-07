import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        System.out.println(s.partition("a"));
        System.out.println(s.partition("aa"));
        System.out.println(s.partition("ab"));
        System.out.println(s.partition("bab"));
        System.out.println(s.partition("aaa"));
        System.out.println(s.partition("aab"));
        // System.out.println(s.partition("aaaaaaaaaaaaaaaaaaaaaaaa"));
        // System.out.println(s.partition("aaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(s.partition("amanaplanacanalpanama"));
        System.out.println(s.partition("kwtbjmsjvbrwriqwxadwnufplszhqccayvdhhvscxjaqsrmrrqngmuvxnugdzjfxeihogzsdjtvdmkudckjoggltcuybddbjoizu"));
    }

    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        int length   = chars.length;

        List<List<String>> solutions = new LinkedList<List<String>>();
        List<String> solution        = new LinkedList<String>();

        partition(solutions, solution, chars, 0, length);

        return solutions;
    }

    public void partition(
        List<List<String>> solutions,
        List<String> solution,
        char[] chars, int start, int end) {

        if (start == end) {
            solutions.add(solution);
            return;
        }

        if (start == end - 1) {
            solution.add(Character.toString(chars[start]));
            solutions.add(solution);
            return;
        }

        StringBuffer prefixStringBuffer = new StringBuffer();
        prefixStringBuffer.append(chars[start]);

        for (int i = start + 1; i <= end; i++) {
            if (isPalindrome(chars, start, i)) {
                String prefixString = prefixStringBuffer.toString();

                int originSize = solution.size();
                solution.add(prefixString);
                partition(solutions, solution, chars, i, end);

                List<String> sub = new LinkedList<String>();
                for (int k = 0; k < originSize; k++) {
                    sub.add(solution.get(k));
                }
                solution.clear();
                solution.addAll(sub);
            }
            if (i != end) {
                prefixStringBuffer.append(chars[i]);
            }
        }
    }

    private boolean isPalindrome(char[] chars, int start, int end) {
        int j = end - 1;
        int i = start;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

}
