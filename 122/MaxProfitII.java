public class MaxProfitII {
    public static int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int profit = 0;
        for(int i = 1; i<prices.length; ++i){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1] ;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] input = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(input));
    }
}
