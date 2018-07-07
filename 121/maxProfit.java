public class maxProfit {
    public static int maxProfit(int[] prices) {
        if(prices.length==0||prices.length==1) return 0;
        int max = 0;
        int min = prices[0];
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > min) max = Math.max(max, prices[i] - min);
            else min = prices[i];
        }
        return max;
    }

    public static void main(String[] args){
        int[] prices = new int[]{2,1,4,5,6,7};
        System.out.println(maxProfit(prices));
    }
}
