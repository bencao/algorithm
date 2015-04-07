  /** * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
      	print(createList());
      	print(s.removeNthFromEnd(createList(), 1));
      	print(s.removeNthFromEnd(createList(), 2));
      	print(s.removeNthFromEnd(createList(), 3));
      	print(s.removeNthFromEnd(createList(), 4));
        print(s.removeNthFromEnd(createList(), 5));
    }

    public static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            System.out.print(", ");
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode createList() {
       ListNode n1 = new ListNode(1);
       ListNode n2 = new ListNode(2);
       ListNode n3 = new ListNode(3);
       ListNode n4 = new ListNode(4);
       ListNode n5 = new ListNode(5);
       n1.next = n2;
       n2.next = n3;
       n3.next = n4;
       n4.next = n5;
       return n1;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode nthBefore = null;
        ListNode pNthBefore = null;
        int distance = 0;
        while (current != null) {
            current = current.next;
            if (nthBefore != null) {
                nthBefore = nthBefore.next;
            }
            if (pNthBefore != null) {
                pNthBefore = pNthBefore.next;
            }
            distance += 1;
            if (distance == n) {
                nthBefore = head;
            }
            if (distance == n + 1) {
                pNthBefore = head;
            }
        }
        if (nthBefore == null) {
            return head;
        }
        if (nthBefore == head) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        pNthBefore.next = nthBefore.next;
        nthBefore.next = null;
        return head;
    }
}
