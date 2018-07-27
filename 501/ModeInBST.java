import java.util.*;
public class ModeInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = 1, sum = 1;
    TreeNode prev;
    ArrayList<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traverse(root);
        if(sum == max) list.add(prev.val);
        else if(sum > max){
            list.clear(); list.add(prev.val);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i<res.length; ++i) res[i] = list.get(i);
        return res;
    }

    private void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        if(prev != null){
            if(prev.val == root.val) sum++;
            else {
                if(sum > max){
                    max = sum;
                    list.clear(); list.add(prev.val);
                } else if(sum == max) list.add(prev.val);
                sum = 1;
            }
        }
        prev = root;
        traverse(root.right);
    }
}
