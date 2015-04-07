/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private TreeNode cursor;

    public BSTIterator(TreeNode root) {
        cursor = root;
        while (cursor.left != null) {
            cursor = cursor.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cursor != null;
    }

    /** @return the next smallest number */
    public int next() {
        int nextNumber = cursor.val;
        // move cursor to next position
        if (cursor.right != null) {
            cursor = cursor.right;
            while (cursor.left != null) {
                cursor = cursor.left;
            }
        } else {
            // get cursor parent
            TreeNode parent = getParentNode(cursor);
            if (parent == null) { cursor = null; }

            // cursor is parent's left child
            if (cursor == parent.left) {
                cursor = parent;
            } else {
                cursor = parent;
                while (getParentNode(parent))
            }
        }
        // cursor = cursor.right if cursor.right != null

        return nextNumber;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
