public class Contest95 {
    /* ------------ Problem 1 ------------------*/

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /* ------------ Problem 2 ------------------*/

    public boolean stoneGame(int[] p) {
        int n = p.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = p[i];
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
        return dp[0][n - 1] > 0;
    }


    /* ------------ Problem 3 ------------------*/
    public int nthMagicalNumber(int N, int A, int B) {
        long l = 0, r = Math.max(A,B) * 1000000000;
        int lcm = A*B/gcd(A,B);

        while (l < r) {
            long m = (l + r) / 2;
            /* The magic number <= x equals (x/A + x/B - x/lcm) */
            if (m / A + m / B - m / lcm < N) l = m + 1;
            else r = m;
        }
        return (int)(l % 1000000007);
    }

    /** greatest common divisor */
    private int gcd(int a, int b){
        while(b > 0){
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    /* ------------ Problem 4 ------------------*/

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] dp = new int[P + 1][G + 1];
        dp[0][0] = 1;
        int res = 0, mod = 1000000007;
        for (int k = 0; k < group.length; k++) {
            int g = group[k], p = profit[k];
            for (int i = P; i >= 0; i--)
                for (int j = G - g; j >= 0; j--)
                    dp[Math.min(i + p, P)][j + g] = (dp[Math.min(i + p, P)][j + g] + dp[i][j]) % mod;
        }
        for (int x : dp[P]) res = (res + x) % mod;
        return res;
    }

}
