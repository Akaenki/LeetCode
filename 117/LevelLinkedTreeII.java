import java.util.*;
public class LevelLinkedTreeII {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    /** O(N) space **/
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeLinkNode cur = q.poll();
            if(cur.left!=null && cur.right!=null){
                cur.left.next = cur.right;
                cur.right.next = findnext(cur.next);
                q.offer(cur.left); q.offer(cur.right);
            } else if(cur.left != null){
                cur.left.next = findnext(cur.next);
                q.offer(cur.left);
            } else if(cur.right != null){
                cur.right.next = findnext(cur.next);
                q.offer(cur.right);
            }

        }
    }

    /** O(1) space */
    public void connect2(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode sentinel = new TreeLinkNode(0),
                    top = sentinel;
            while(root != null){
                if(root.left != null){
                    top.next = root.left;
                    top = top.next;
                }
                if(root.right != null){
                    top.next = root.right;
                    top = top.next;
                }
                root = root.next;
            }
            root = sentinel.next;
        }
    }

    private TreeLinkNode findnext(TreeLinkNode root){
        if(root == null) return null;
        if(root.left != null) return root.left;
        if(root.right != null) return root.right;
        return findnext(root.next);
    }

    public static void main(String[] args) {

    }
}
