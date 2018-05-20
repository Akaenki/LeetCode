/** Iterative solution using stack */
import java.util.Stack;
public class convertBSTItr {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode head = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root.val += sum;
            sum = root.val;
            root = root.left;
        }
        return head;
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
