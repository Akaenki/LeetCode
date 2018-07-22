import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class TreeConverter {
    /** Use String Builder which can do fast on concatenation */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        buildStr(root, str);
        return str.toString();
    }

    private void buildStr(TreeNode root, StringBuilder str){
        if(root == null) str.append("null,");
        str.append(root.val).append(",");
        buildStr(root.left, str); buildStr(root.right, str);
    }

    public TreeNode deserialize(String data){
        LinkedList<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return buildTree(q);
    }

    private TreeNode buildTree(LinkedList<String> q){
        String cur = q.poll();
        if(cur.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
    }


    public static void main(String[] args) {
        TreeConverter o = new TreeConverter();
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
