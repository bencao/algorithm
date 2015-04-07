public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] p1 = {2, 1, 3};
        int[] i1 = {1, 2, 3};
        TreeNode t1 = s.buildTree(p1, i1);
        t1.println();

        int[] p2 = {3, 2, 1};
        int[] i2 = {1, 2, 3};
        TreeNode t2 = s.buildTree(p2, i2);
        t2.println();

        int[] p3 = {1, 2, 3};
        int[] i3 = {1, 2, 3};
        TreeNode t3 = s.buildTree(p3, i3);
        t3.println();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRecursively(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeRecursively(
        int[] preorder, int pStart, int pEnd,
        int[] inorder, int iStart, int iEnd) {

        if (pStart > pEnd) {
            return null;
        }

        int rootNumber = preorder[pStart];
        int index = indexInArray(inorder, iStart, iEnd, rootNumber);
        int nodesInLeftTree = index - iStart;

        TreeNode root = new TreeNode(rootNumber);
        root.left = buildTreeRecursively(
            preorder, pStart + 1, pStart + nodesInLeftTree,
            inorder, iStart, index - 1
        );
        root.right = buildTreeRecursively(
            preorder, pStart + nodesInLeftTree + 1, pEnd,
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
