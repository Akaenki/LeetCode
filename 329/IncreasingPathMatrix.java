public class IncreasingPathMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        if(matrix.length == 0) return max;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<matrix.length; ++i){
            for(int j = 0; j<matrix[0].length; ++j){
                int sum = larger(matrix,dp,i,j,matrix[i][j]-1);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private int larger(int[][] matrix,int[][] dp, int i, int j, int prev){
        if(matrix[i][j] <= prev) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int a = 0 , b = 0, c = 0, d = 0;
        if(i > 0) a = larger(matrix,dp,i-1,j,matrix[i][j]);
        if(i < matrix.length-1) b = larger(matrix,dp,i+1,j,matrix[i][j]);
        if(j > 0) c = larger(matrix,dp,i,j-1,matrix[i][j]);
        if(j < matrix[0].length-1) d = larger(matrix,dp,i,j+1,matrix[i][j]);
        int max = Math.max(Math.max(c,d),Math.max(a,b));
        dp[i][j] = Math.max(max, dp[i][j]);
        return max;
    }
}
