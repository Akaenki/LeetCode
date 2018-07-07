import java.util.Stack;

public class sameTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    /* Recursive solution */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q==null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }

    /* Iterative solution (always try to find an iterative method,
    due to possible stack overflow encounter by recursive solution for large trees) */
    public static boolean isSameTreeItr(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Stack<TreeNode> ps = new Stack<>(), qs = new Stack<>();
        ps.push(p); qs.push(q);

        while(!ps.isEmpty() && !qs.isEmpty()){
            TreeNode pt = ps.pop(), qt = qs.pop();
            if(pt.val != qt.val) return false;

            if(pt.left != null && qt.left != null) {
                ps.push(pt.left);
                qs.push(qt.left);
            } else if(!(pt.left == null && qt.left == null)) return false;
            if(pt.right != null && qt.right != null) {
                ps.push(pt.right);
                qs.push(qt.right);
            } else if(!(pt.right == null && qt.right == null)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        System.out.println(isSameTreeItr(p, q));
    }
}
