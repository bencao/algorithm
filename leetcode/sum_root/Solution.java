/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.LinkedList;
import java.util.ListIterator;
import java.math.BigDecimal;

public class Solution {
    
    public int sumNumbers(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        BigDecimal n = depthFirstTraverse(list, root);
        try {
            return n.intValueExact();
        } catch (ArithmeticException e) {
            return 0;
        }
        
    }
    
    public BigDecimal depthFirstTraverse(LinkedList<Integer> list, TreeNode node) {
        if (node == null) {
            return new BigDecimal(0);
        }
        if (node.left == null && node.right == null) {
            BigDecimal c = new BigDecimal(node.val);
            BigDecimal m = new BigDecimal(10);
            ListIterator<Integer> iter = list.listIterator();
            while (iter.hasNext()) {
                c = c.add(new BigDecimal(iter.next()).multiply(m));
                m = m.multiply(new BigDecimal(10));
            } 
            return c;
        } 
        list.push(node.val);
        BigDecimal c = new BigDecimal(0);
        if (node.left != null) {
            c = c.add(depthFirstTraverse(list, node.left));
        } 
        if (node.right != null) {
            c = c.add(depthFirstTraverse(list, node.right));
        }
        list.pop();
        return c;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
    	node1.left = node2;
    	node1.right = node3;
    	node2.left = node4;
        node2.right = node5;

        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(node4));
        System.out.println(solution.sumNumbers(node2));
        System.out.println(solution.sumNumbers(node1));
    }


}
