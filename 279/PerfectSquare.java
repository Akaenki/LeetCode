import java.util.*;
public class PerfectSquare {
    public static int numSquares(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0); dp.add(1);
        while(dp.size() <= n){
            int cur = Integer.MAX_VALUE;
            for(int i = 1; i*i <= dp.size(); ++i){
                cur = Math.min(cur, dp.get(dp.size()-i*i) + 1);
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
