import java.util.Deque;
import java.util.LinkedList;

/** Iterative solution using deque */
public class symmetricTreeItr {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root.left);
        queue.addLast(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeLast();
            if(left==null && right==null) continue;
            if(left==null || right==null || left.val!=right.val) return false;
            queue.addFirst(left.right);
            queue.addFirst(left.left);
            queue.addLast(right.left);
            queue.addLast(right.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(4);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(3);

        System.out.println(isSymmetric(t1));
    }
}
