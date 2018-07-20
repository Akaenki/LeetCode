import java.util.*;
public class KthSmallestBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /* Do inorder traversal */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        return inorder.get(k-1);
    }

    private void inorder(TreeNode root, List<Integer> inorder){
        if(root == null) return;
        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }

    private int res, count = 0;
    public int kthSmallest2(TreeNode root, int k) {
        findKth(root, k);
        return res;
    }

    private void findKth(TreeNode root, int k){
        if(root == null) return;
        findKth(root.left, k);
        count++;
        if(count == k){
            res = root.val; return;
        }
        findKth(root.right, k);
    }


}
