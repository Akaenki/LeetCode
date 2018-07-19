public class UniquePathII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0] != 1) dp[0][0] = 1;
        for(int i = 1; i<n; ++i) {
            if(obstacleGrid[0][i] != 1) dp[0][i] = dp[0][i-1];
        }
        for(int i = 1; i<m; ++i){
            if(obstacleGrid[i][0] != 1) dp[i][0] = dp[i-1][0];
        }

        for(int i = 1; i<m; ++i){
            for(int j = 1; j<n; ++j){
                if(obstacleGrid[i][j] != 1) dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(input));
    }
}
