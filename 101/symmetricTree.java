/** Recursive solution */
public class symmetricTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public static boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right == null) return true;
        if(left!=null && right!=null && left.val==right.val)
            return isSymmetric(left.right,right.left) && isSymmetric(left.left,right.right);
        return false;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(5);
        //t1.right.right = new TreeNode(3);

        System.out.println(isSymmetric(t1));
    }
}
