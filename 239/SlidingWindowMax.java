public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int[] dp = new int[nums.length-k+1];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<k; ++i) max = Math.max(max, nums[i]);

        dp[0] = max;
        for(int i = k, ptr = 1; i<nums.length; ++i, ++ptr){
            if(nums[i] >= dp[ptr-1]) dp[ptr] = nums[i];
            else if(nums[i-k] != dp[ptr-1]) dp[ptr] = dp[ptr-1];
            else{
                max = Integer.MIN_VALUE;
                for(int j = i-k+1; j<=i; ++j) max = Math.max(max, nums[j]);
                dp[ptr] = max;
            }
        }
        return dp;
    }
}
