public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max = dp[0][0];
        for(int i = 0; i < m; ++i) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            max = Math.max(max, dp[i][0]);
        }
        for(int i = 1; i < n; ++i) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            max = Math.max(max, dp[0][i]);
        }

        for(int i = 1; i<m; ++i){
            for(int j = 1; j<n; ++j){
                if(matrix[i][j]!='0') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1])+1, dp[i - 1][j - 1] + 1);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
