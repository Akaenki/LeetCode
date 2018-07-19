public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = dungeon[m-1][n-1] <= 0 ? -dungeon[m-1][n-1] + 1 : 1;

        for(int i = m-2; i>=0; --i)
            dp[i][n-1] = dp[i+1][n-1] - dungeon[i][n-1] > 0 ? dp[i+1][n-1] - dungeon[i][n-1] : 1;

        for(int i = n-2; i>=0; --i)
            dp[m-1][i] = dp[m-1][i+1] - dungeon[m-1][i] > 0 ? dp[m-1][i+1] - dungeon[m-1][i] : 1;

        for(int j = n - 2; j>=0; --j) {
            for (int i = m - 2; i >= 0; --i) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (dp[i][j] <= 0) dp[i][j] = 1;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(input));
    }
}
