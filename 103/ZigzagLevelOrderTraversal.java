import java.util.*;
public class ZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        boolean reverse = false;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        TreeNode partition = new TreeNode(0);
        q.offer(root); q.offer(partition);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == partition){
                res.add(level);
                level = new LinkedList<>();
                q.offer(partition);
                reverse = !reverse;
                if(q.peek()==partition) return res;
                continue;
            }
            if(cur.left != null) q.offer(cur.left);
            if(cur.right != null) q.offer(cur.right);

            if(reverse) ((LinkedList<Integer>) level).addFirst(cur.val);
            else ((LinkedList<Integer>) level).addLast(cur.val);
        }
        return res;
    }
}
