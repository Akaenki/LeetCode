public class MaxPathSumSolution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxBranch(root);
        return sum;
    }

    private int maxBranch(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(maxBranch(root.left), 0);
        int right = Math.max(maxBranch(root.right), 0);
        sum = Math.max(sum, left + right + root.val);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        MaxPathSumSolution o = new MaxPathSumSolution();
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(2);
        root.right.right.right.left = new TreeNode(-6);

        System.out.println(o.maxPathSum(root));
    }
}
