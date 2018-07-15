public class TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    private static int findTargetSumWays(int[] nums, int cur, int S){
        if(cur == nums.length - 1){
            if(nums[cur] == S && -nums[cur] == S) return 2;
            else if(nums[cur] == S || -nums[cur] == S) return 1;
            else return 0;
        }
        return findTargetSumWays(nums, cur+1, S-nums[cur])
                + findTargetSumWays(nums, cur+1, S+nums[cur]);
    }

    /** Dynamic Programming solution. Converting the problem into:
     *  Find the subset P of nums such that
     *          sum(P) = (S + sum(nums)) / 2*/
    public static int solution(int[] nums, int s){
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) / 2);
    }

    private static int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }


    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution(input, 3));
    }
}
