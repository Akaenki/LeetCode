public class MaxPathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** A trivial solution but super inefficient. Here we are traversing the branch
     *  multiple times. To reduce that use a global variable to track the maxSum when
     *  traversing branches.
     */
    public int maxPathSum(TreeNode root) {
        int leftsum = maxBranch(root.left), rightsum = maxBranch(root.right);
        int cur = Math.max(Math.max(root.val + leftsum, root.val + rightsum),
                Math.max(root.val, root.val + leftsum + rightsum));
        int left = root.left == null ? Integer.MIN_VALUE : maxPathSum(root.left);
        int right = root.right == null ? Integer.MIN_VALUE : maxPathSum(root.right);
        return Math.max(cur, Math.max(left, right));
    }

    private int maxBranch(TreeNode root) {
        if(root == null) return 0;
        return Math.max(Math.max(root.val, root.val + maxBranch(root.left)), root.val + maxBranch(root.right));
    }

    public static void main(String[] args) {
        MaxPathSum o = new MaxPathSum();
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(2);
        root.right.right.right.left = new TreeNode(-6);

        System.out.println(o.maxPathSum(root));
    }
}
