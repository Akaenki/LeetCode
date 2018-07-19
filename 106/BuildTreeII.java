public class BuildTreeII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /** Post-order:  left - right - root, In-order: left - root - right
     *  Example:              left        right   root
     *            post:   [4  1  3  6]  [8  9  2]  {7}
     *                        left     root    right
     *              in:   [4  6  3  1]  {7}  [9  8  2]
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length < 1) return null;
        return build(inorder, postorder,0,inorder.length-1, inorder.length-1);
    }

    private TreeNode build(int[] in, int[] post, int istart, int iend, int pend){
        if(pend < 0 || istart > iend) return null;
        TreeNode root = new TreeNode(post[pend]);
        int iroot = 0;
        for(int i = 0; i<=iend; ++i){
            if(in[i] == root.val) iroot = i;
        }
        int left = iroot - istart, right = iend - iroot;
        root.left = build(in, post, istart, iroot-1, pend - right - 1);
        root.right = build(in, post, iroot+1, iend, pend - 1);
        return root;
    }
}
