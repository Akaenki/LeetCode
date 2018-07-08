import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

public class levelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelorder = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return levelorder;

        TreeNode partition = new TreeNode(0);

        queue.offer(root);
        queue.offer(partition);

        List<Integer> level = new LinkedList<>();
        while(!queue.isEmpty()){
            TreeNode ptr = queue.poll();
            if(ptr.equals(partition)){
                levelorder.add(level);
                if(queue.isEmpty()) return levelorder;
                level = new LinkedList<>();
                queue.offer(partition);
                continue;
            }
            level.add(ptr.val);
            if(ptr.left != null) queue.offer(ptr.left);
            if(ptr.right != null) queue.offer(ptr.right);
        }
        return levelorder;
    }

    /* This is a FAKE solution that actually do pre-order traversal
        but form the returned list as level-ordered. */
    public static List<List<Integer>> levelOrderFake(TreeNode root){
        List<List<Integer>> levelorder = new LinkedList<>();
        levelOrderFake(root, levelorder, 0);
        return levelorder;
    }

    private static void levelOrderFake(TreeNode root, List<List<Integer>> list, int level){
        if(root == null) return;
        if(list.size() <= level) list.add(new LinkedList<>());
        list.get(level).add(root.val);
        levelOrderFake(root.left, list, level+1);
        levelOrderFake(root.right, list, level+1);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(9);
        List<List<Integer>> levelorder = levelOrder(root);
        System.out.println(levelorder.toString());
    }
}
