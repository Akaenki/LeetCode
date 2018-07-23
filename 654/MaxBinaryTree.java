public class MaxBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);

        TreeNode root = new TreeNode(nums[0]), top = root;

        for(int i = 1; i<nums.length; ++i){
            if(nums[i] <= top.val){
                top.right = new TreeNode(nums[i]);
                top = top.right;
            } else if(nums[i] > root.val){
                top = new TreeNode(nums[i]);
                top.left = root; root = top;
            } else{
                top = root;
                while(nums[i] < top.right.val) top = top.right;
                TreeNode temp = new TreeNode(nums[i]);
                temp.left = top.right;
                top.right = temp; top = top.right;
            }
        }
        return root;
    }
}
