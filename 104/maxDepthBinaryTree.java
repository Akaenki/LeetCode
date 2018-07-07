public class maxDepthBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public static int maxDepth(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        if(root.left==null && root.right!=null) return maxDepth(root.right)+1;
        if(root.left!=null && root.right==null) return maxDepth(root.left)+1;
        /* Actually only this line is needed, realized that after failed for a null input */
        return 1 + Math.max(maxDepth(root.right),maxDepth(root.left));
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);


        System.out.println(maxDepth(root));
    }
}
