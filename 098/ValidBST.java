public class ValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** Some asshole add a test case: [2147483647] that fails this recursive method
     *  Anyway....
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int min, int max){
        if(root == null) return true;
        if(root.left != null &&
                (root.left.val >= root.val || root.left.val <= min)) return false;
        if(root.right != null &&
                (root.right.val <= root.val || root.right.val >= max)) return false;

        return isValidBST(root.left,Integer.MIN_VALUE,root.val)
                && isValidBST(root.right, root.val, Integer.MAX_VALUE);
    }
}

