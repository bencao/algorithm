public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public void print() {
	System.out.print(val);
	ListNode n = next;
        while (n != null) {
	    System.out.print(", ");
	    System.out.print(n.val);
	    n = n.next;
    	}
	System.out.println();
    }
}

