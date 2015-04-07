public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(1));
        System.out.println(s.isPalindrome(0));
        System.out.println(s.isPalindrome(101));
        System.out.println(s.isPalindrome(1001));
        System.out.println(!s.isPalindrome(-1289));
        System.out.println(s.isPalindrome(2112));
        System.out.println(s.isPalindrome(9999));
        System.out.println(!s.isPalindrome(19999));
        System.out.println(s.isPalindrome(99999));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int base = 1;
        while ((x / base) > 9) {
            base *= 10;
        }

        int current = x;
        while (base > 0) {
            int reminder = current % 10;
            if ((current / base) != reminder) {
                return false;
            }
            if (reminder == 0) {
                current = current / 10;
            } else {
                current = (current % ((current % 10) * base)) / 10;
            }
            base = base / 100;
        }

        return true;
     }
}
