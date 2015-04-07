public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersectionNode = null;
        
        // reverse list so we can handle it easier
        ListNode tailA = reverse(headA);
        ListNode tailB = reverse(headB);
        
        ListNode pa = tailA;
        ListNode pb = tailB;
        while (pa != null && pb != null) {
            if (pa.val == pb.val) {
                intersectionNode = pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
        
        // reverse list again to restore it to original state
        reverse(tailA);
        reverse(tailB);
        
        return intersectionNode;
    }
    
    public ListNode reverse(ListNode node) {
       ListNode reversedNode = null;
       
       while (node != null) {
           ListNode nextNode = node.next;
           node.next = reversedNode;
           reversedNode = node;
           node = nextNode;
       }
       
       return reversedNode;
    }
}
