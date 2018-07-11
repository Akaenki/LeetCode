public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int pathSum(TreeNode root, int sum){
        if(root == null) return 0;
        return searchBranch(root, sum) + pathSum(root.left,sum) + pathSum(root.right, sum);
    }

    private static int searchBranch(TreeNode root, int sum){
        if(root == null) return 0;
        if(root.val == sum) return 1 + searchBranch(root.left, 0) + searchBranch(root.right, 0);
        return searchBranch(root.left, sum-root.val) + searchBranch(root.right, sum-root.val);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }
}
