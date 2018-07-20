import java.util.LinkedList;
import java.util.Queue;

public class SecondMinimumNode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findSecondMinimumValue(TreeNode root) {
        int smallest = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left != null && cur.left.val == smallest)
                q.offer(cur.left);
            else if(cur.left != null && cur.left.val > smallest)
                min = Math.min(min,cur.left.val);

            if(cur.right != null && cur.right.val == smallest)
                q.offer(cur.right);
            else if(cur.right != null && cur.right.val > smallest)
                min = Math.min(min, cur.right.val);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
