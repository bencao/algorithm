public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] p1 = {2, 3, 1};
        int[] i1 = {2, 1, 3};
        TreeNode t1 = s.buildTree(i1, p1);
        t1.println();

        int[] p2 = {3, 2, 1};
        int[] i2 = {1, 2, 3};
        TreeNode t2 = s.buildTree(i2, p2);
        t2.println();

        int[] p3 = {3, 2, 1};
        int[] i3 = {1, 2, 3};
        TreeNode t3 = s.buildTree(i3, p3);
        t3.println();

        String ss = "abc";

        System.out.println(ss.length());
        System.out.println(ss.charAt(1));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRecursively(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeRecursively(
        int[] postorder, int pStart, int pEnd,
        int[] inorder, int iStart, int iEnd) {

        if (pStart > pEnd) {
            return null;
        }

        int rootNumber = postorder[pEnd];
        int index = indexInArray(inorder, iStart, iEnd, rootNumber);
        int nodesInLeftTree = index - iStart;

        TreeNode root = new TreeNode(rootNumber);
        root.left = buildTreeRecursively(
            postorder, pStart, pStart + nodesInLeftTree - 1,
            inorder, iStart, index - 1
        );
        root.right = buildTreeRecursively(
            postorder, pStart + nodesInLeftTree, pEnd - 1,
            inorder, index + 1, iEnd);
        return root;
    }

    public int indexInArray(int[] array, int start, int end, int number) {
        for (int i = start; i <= end; i ++) {
            if (array[i] == number) {
                return i;
            }
        }
        throw new RuntimeException("invalid input");
    }
}
