public class MaxProfitCooldown {
    /** Three state DP: each step can be either {buy, sell, cooldown}
     *  To get into buy state the previous state must be cooldown or buy
     *  To get into sell state the previous states must be buy or sell
     *  Can get into cooldown state from any states */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        int[] buy = new int[n],
                sell = new int[n],
                rest = new int[n];
        buy[0] = -prices[0];
        sell[0] = Integer.MIN_VALUE;
        rest[0] = 0;
        for(int i = 1; i<prices.length; ++i){
            buy[i] = Math.max(buy[i-1], rest[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            rest[i] = Math.max(Math.max(buy[i-1], sell[i-1]),rest[i-1]);
        }
        return Math.max(sell[n-1],rest[n-1]);
    }

    /** Since all the ith elements only depends on i-1, can reduce the space to O(1) */

    public static void main(String[] args) {
        int[] input = new int[]{1,2};
        System.out.println(maxProfit(input));
    }
}

