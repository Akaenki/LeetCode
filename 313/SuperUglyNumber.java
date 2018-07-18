public class SuperUglyNumber {
    /** Adapted from ugly number II */
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] p = new int[primes.length];
        int[] m = new int[primes.length];
        dp[0] = 1;
        for(int i = 1; i<n; ++i){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j<p.length; ++j) {
                m[j] = primes[j] * dp[p[j]];
                min = Math.min(min, m[j]);
            }
            dp[i] = min;
            for(int j = 0; j<p.length; ++j){
                if(dp[i] == m[j]) p[j]++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] p = new int[]{2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(1, p));
    }
}
