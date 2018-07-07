/** Compute the longest path between any elements in the Binary Tree
 *
 *  My original solution which is really ugly --
 *  evaluate(): changes the value of each node as the max length of path in its subtress
 *      which is just the maxdepth of left tree + maxdepth of right tree
 *  highest(): Traverse the modified tree to find the max path
 *  This do pass all the test but is extremely slow due to too many recursions
 *
 *  A better solution is to make the depth() function returns 2 integer values
 *  [max, depth], save a lot of time
 *  */

public class diameterOfBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        /** Original Solution */
        //evaluate(root);
        //return highest(root);

        return maxDepth(root)[0];
    }

    private static int depth(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(depth(root.right),depth(root.left));
    }

    private static int[] maxDepth(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] left = maxDepth(root.left);
        int[] right = maxDepth(root.right);
        int max = Math.max(left[1]+right[1],Math.max(left[0],right[0]));
        return new int[]{max,1+Math.max(left[1],right[1])};
    }

    private static void evalue(TreeNode root){
        if(root!=null){
            root.val = depth(root.left) + depth(root.right);
            evalue(root.left);
            evalue(root.right);
        }
    }

    private static int highest(TreeNode root){
        if(root==null) return 0;
        int max = Math.max(highest(root.left),highest(root.right));
        return Math.max(max,root.val);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(3);
        t1.right.right.right = new TreeNode(3);

        System.out.println(diameterOfBinaryTree(t1));
    }
}
