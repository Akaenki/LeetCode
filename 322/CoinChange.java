public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i<=amount; i++){
            int min = Integer.MAX_VALUE;
            for(int c : coins){
                if(i >= c) min = Math.min(min, dp[i-c]);
            }
            dp[i] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
