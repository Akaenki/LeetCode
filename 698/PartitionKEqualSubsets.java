public class PartitionKEqualSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) return false;
        if (k == 1) return true;

        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        sum /= k;

        return partition(nums, new boolean[nums.length], sum, k, 0, 0, 0);
    }

    private boolean partition(int[] nums, boolean[] visited, int sum, int k, int start, int cur, int count){
        if(k == 1) return true;
        if(cur == sum && count > 0) return partition(nums, visited, sum, k-1,0,0,0);
        for(int i = start; i<nums.length; ++i){
            if(!visited[i]){
                visited[i] = true;
                if(partition(nums, visited, sum, k, i+1, cur+nums[i], count++)) return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionKEqualSubsets o = new PartitionKEqualSubsets();
        int[] input = new int[]{2,2,2,2,3,4,5};
        System.out.println(o.canPartitionKSubsets(input, 4));
    }
}
