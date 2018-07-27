import java.util.*;
public class UniqueBSTII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {
            res.add(null); return res;
        }
        if(start == end) {
            res.add(new TreeNode(start)); return res;
        }
        for(int i = start; i<=end; ++i){
            List<TreeNode> left = build(start, i-1), right = build(i+1, end);
            for(TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
