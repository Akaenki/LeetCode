public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0) return false;
        int half = sum / 2;

        boolean[] dp = new boolean[half + 1]; dp[0] = true;
        for(int n : nums){
            if(n > half) return false;
            for(int s = half; s > 0; --s){
                if(n <= s) dp[s] = dp[s] || dp[s-n];
            }
        }
        return dp[half];
    }

    public static void main(String[] args) {
        int[] input = new int[]{100,100,100,100,100,100,100,100,100,100};
        System.out.println(canPartition(input));
    }
}
