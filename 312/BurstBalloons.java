public class BurstBalloons {
    /** Each time put a balloon i back to the list
     * i is guaranteed to the the last one if the coin is maxed before bursting i
     * dived the problem into (start - 1) maxCoins(start, i-1) (i) maxCoin(i+1, end) (end+1)
     * (start-1) (i) (end+1) will always b e the boundary when we put back the next balloon
     * Therefore the problem is now become:
     *
     * *Find the idx i so that (start-1)*i*(end+1) + maxCoin(start, i-1) + maxCoin(i+1, end)
     * is maximized*
     */
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return maxCoins(nums, dp, 0, nums.length-1);
    }

    /** dp stores the max coins can be earned from the subproblem maxCoin(start, end) */
    private int maxCoins(int[] nums, int[][] dp, int start, int end){
        if(start > end) return 0;
        if(dp[start][end] != 0) return dp[start][end];

        int max = 0;
        for(int i = start; i<=end; ++i){
            int cur = getval(nums,i)*getval(nums,start-1)*getval(nums,end+1) +
                    maxCoins(nums, dp, start, i) + maxCoins(nums, dp, i+1, end);
            max = Math.max(max, cur);
        }
        dp[start][end] = max;
        return max;
    }

    private int getval(int[] nums, int i) {
        if (i == -1 || i == nums.length) return 1;
        return nums[i];
    }

    /* Non-recursive */
    public int maxCoins2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[][] dp = new int[n][n];

        for(int len = 1; len <= n; len++){
            for(int start = 0; start <= n - len ; start++){
                int end = len + start - 1;
                for(int i = start; i <= end; i++){
                    int cur = getval(nums, start-1)*getval(nums, i)*getval(nums,end+1);
                    if(i != start) cur += dp[start][i - 1];
                    if(i != end)   cur += dp[i+1][end];
                    dp[start][end] = Math.max(dp[start][end], cur);
                }
            }
        }
        return dp[0][n-1];
    }

}
