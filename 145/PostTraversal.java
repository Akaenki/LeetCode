import java.util.*;
public class PostTraversal {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        TreeNode ptr = root;
        while(!stack.isEmpty() || ptr != null){
            if(ptr!=null){
                res.addFirst(ptr.val);
                if(ptr.left != null) stack.push(ptr);
                ptr = ptr.right;
            } else{
                ptr = stack.pop().left;
            }
        }
        return res;
    }
}
