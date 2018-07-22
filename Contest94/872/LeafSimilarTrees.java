package Contest94;
import java.util.*;

public class LeafSimilarTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        traverse(root1, l1); traverse(root2, l2);
        if(l1.size() != l2.size()) return false;
        for(int i = 0; i<l1.size(); ++i){
            if(l1.get(i) != l2.get(i)) return false;
        }
        return true;
    }

    private void traverse(TreeNode root, List<Integer> list){
        if(root.left == null && root.right == null) list.add(root.val);

        if(root.left != null) traverse(root.left,list);
        if(root.right != null) traverse(root.right,list);
    }
}
