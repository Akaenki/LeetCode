public class HouseRobberIII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        int[] max = maxBranch(root);
        return Math.max(max[0], max[1]);
    }

    /** First returned value is the max value if do not rob current root
     *  Second returned value is the max value if rob current root
     */
    private int[] maxBranch(TreeNode root) {
        if(root == null) return new int[]{0,0};
        int[] left = maxBranch(root.left);
        int[] right = maxBranch(root.right);
        int[] max = new int[2];
        max[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        max[1] = root.val + left[0] + right[0];
        return max;
    }

    public static void main(String[] args) {
        HouseRobberIII o = new HouseRobberIII();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(o.rob(root));
    }
}
