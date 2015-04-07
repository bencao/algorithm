class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(5);
        node2.next.next.next.next.next = new ListNode(6);

        Solution solution = new Solution();
        ListNode n = solution.getIntersectionNode(node1, node2);
    	n.print();
    	node1.print();
	    node2.print();

        System.out.println(-13);
        System.out.println(reverse(-13));

        System.out.println(13);
        System.out.println(reverse(13));

        System.out.println(123);
        System.out.println(reverse(123));

        System.out.println(10);
        System.out.println(reverse(10));

        System.out.println(0);
        System.out.println(reverse(0));

        System.out.println(-655350);
        System.out.println(reverse(-655350));

    	System.out.println(-2147483648);
        System.out.println(reverse(-2147483648));

        System.out.println(-2147483647);
        System.out.println(reverse(-2147483647));

        System.out.println(1000000003);
    	System.out.println(reverse(1000000003));

        System.out.println(1534236469);
        System.out.println(reverse(1534236469));

        int y = 1000000003 * 10;
        System.out.println(y + (-y));
        System.out.println(1000000003 * 10);
    }

    public static final int MAX_NUM = 2147483647;
    public static final int MAX_Y = 214748364;
    public static final int MIN_NUM = -2147483648;

    public static int reverse(int x) {
    	try {
    	    if (x < 0) {
                int negativeX = -x;
                if (negativeX < 0) {
                    return 0;
                } else {
                    return - reverse(negativeX);
                }
    	    }
    	    int reminder = x;
    	    int y = 0;
    	    while (reminder >= 10) {
    	        y = y * 10 + reminder % 10; 
    	        reminder = reminder / 10;
     	    }
            if (y > MAX_Y || (y == MAX_Y && reminder > 7)) {
                return 0;
            }
    	    y = y * 10 + reminder;
            return y;
        } catch (RuntimeException e) {
            return 0;
      	}
    }
}
