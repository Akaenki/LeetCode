public class BuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** Pre-order: root - left - right, In-order: left - root - right
     *  Example:         root  (tp)  left      right
     *             pre:   {7}  [6  4  3  1]  [2  8  9]
     *                        left (ti) root   right
     *              in:   [4  6  3  1]  {7}  [9  8  2]
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length < 1) return null;
        return build(preorder, inorder, 0, 0, inorder.length-1);
    }

    private TreeNode build(int[] pre, int[] in, int tp, int ti1, int ti2){
        if(ti1 > ti2 || tp > pre.length) return null;
        TreeNode root = new TreeNode(pre[tp]);
        int ti = 0;
        for(int i = ti1; i<= ti2; ++i){
            if(in[i] == root.val) ti = i;
        }
        root.left = build(pre, in, tp + 1, ti1, ti - 1);
        root.right = build(pre, in, tp + ti - ti1 + 1, ti + 1, ti2);

        return root;
    }
}
