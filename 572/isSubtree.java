import java.util.Stack;

public class isSubtree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /* Recursive solution */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null && s == null) return true;
        else if(s == null) return false;
        if(isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q==null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }

    /* Iterative solution: Super Inefficient. Just for fun */
    public static boolean isSubtreeItr(TreeNode s, TreeNode t) {
        if(t == null && s == null) return true;
        else if(s == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);

        while(!stack.empty()){
            TreeNode ptr = stack.pop();
            if(isSameTreeItr(ptr, t)) return true;

            if(ptr.left != null) stack.push(ptr.left);
            if(ptr.right != null) stack.push(ptr.right);
        }
        return false;
    }

    private static boolean isSameTreeItr(TreeNode p, TreeNode q) {
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


    public static void main(String[] args){
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(isSubtree(s, t));
    }
}
