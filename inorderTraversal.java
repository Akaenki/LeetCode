import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    /* Recursive solution */
    public static List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> inorder = new LinkedList<>();
        inorderTraversalRec(root, inorder);
        return inorder;
    }

    private static void inorderTraversalRec(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorderTraversalRec(root.left, list);
        list.add(root.val);
        inorderTraversalRec(root.right, list);
    }

    /* Iterative Solution */
    public static List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inorder = new LinkedList<>();
        if(root == null) return inorder;

        pushLeft(root, stack);

        while(!stack.isEmpty()){
            TreeNode ptr = stack.pop();
            inorder.add(ptr.val);
            if(ptr.right!=null){
                pushLeft(ptr.right, stack);
            }
        }
        return inorder;
    }

    private static void pushLeft(TreeNode root, Stack<TreeNode> stack){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(7);
        List<Integer> inorder = inorderTraversal(root);
        System.out.println(inorder.toString());
    }

}
