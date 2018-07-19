public class FlattenBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode prev = null;
    /** pre-order traversal, must do it in place */
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(5);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(4);
        head.right.right = new TreeNode(6);
    }
}
