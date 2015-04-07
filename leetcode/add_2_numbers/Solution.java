public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(toNum(s.addTwoNumbers(l1, null)).equals("1"));
        System.out.println(toNum(s.addTwoNumbers(null, l1)).equals("1"));
        System.out.println(toNum(s.addTwoNumbers(l2, l1)).equals("433"));
        System.out.println(toNum(s.addTwoNumbers(l1, l2)).equals("433"));
    }

    public static String toNum(ListNode node) {
        ListNode l  = node;

        StringBuffer sb = new StringBuffer();

        while (node != null) {
            sb.insert(0, node.val);
            node = node.next;
        }

        return sb.toString();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode pr = null;

        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;

        while (p1 != null || p2 != null || carry > 0) {
            int v1 = (p1 == null) ? 0 : p1.val;
            int v2 = (p2 == null) ? 0 : p2.val;
            int sum = v1 + v2 + carry;
            carry = (sum >= 10 ? 1 : 0);

            ListNode resultNode = new ListNode(sum % 10);
            if (result == null) {
                result = resultNode;
                pr     = resultNode;
            } else {
                pr.next = resultNode;
                pr      = resultNode;
            }

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        return result;
    }
}
