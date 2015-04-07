public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public void println() {
        iPrint();
        System.out.println();
        pPrint();
        System.out.println();
    }

    public void iPrint() {
        if (left != null) { left.iPrint(); }
        System.out.print(val);
        System.out.print(", ");
        if (right != null) { right.iPrint(); }
    }

    public void pPrint() {
        System.out.print(val);
        System.out.print(", ");
        if (left != null) { left.pPrint(); }
        if (right != null) { right.pPrint(); }
    }
}

