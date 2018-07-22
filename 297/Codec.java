import java.util.*;

/** Unexpected slow, guess is due to string concatenation */
public class Codec {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        LinkedList<TreeNode> q = new LinkedList<>();
        String str = "" + root.val;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left != null){
                q.offer(cur.left); str +=  ", " + cur.left.val;
            } else str += ", null";
            if(cur.right != null){
                q.offer(cur.right); str += ", " + cur.right.val;
            } else str += ", null";
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(", ");
        if(strs[0].equals("null")) return null;
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        int ptr = 1; q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(!strs[ptr++].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(strs[ptr-1]));
                q.offer(cur.left);
            }
            if(!strs[ptr++].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(strs[ptr-1]));
                q.offer(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Codec o = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String d1 = o.serialize(root);
        System.out.println(d1);
        TreeNode r1 = o.deserialize(d1);
        System.out.println(o.serialize(r1));
    }
}
