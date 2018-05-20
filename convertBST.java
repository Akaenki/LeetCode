/** Recursive solution by inverse traversal */
public class convertBST {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public static TreeNode convertBST(TreeNode root) {
        traverseBST(root,0);
        return root;
    }

    private static int traverseBST(TreeNode root,int val){
        if(root == null) return val;
        root.val += traverseBST(root.right,val);
        return traverseBST(root.left,root.val);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(-2);
        root.right.left = new TreeNode(3);

        TreeNode result = convertBST(root);
    }

}
