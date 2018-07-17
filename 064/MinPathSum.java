public class MinPathSum {
    /** Can modify on the original matrix to avoid extra O(n^2) space
     *  Then the method will become destructive.
     */
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){
                if(i == 0 && j == 0) continue;
                if(i == 0) dp[i][j] = dp[i][j-1]+grid[i][j];
                else if(j == 0) dp[i][j] = dp[i-1][j] + grid[i][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(input));
    }
}
