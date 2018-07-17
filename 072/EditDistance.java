public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int n = word1.length()+1, m = word2.length()+1;
        int[][] dp = new int[n][m];
        for(int i = 0; i<n; ++i) dp[i][0] = i;
        for(int j = 0; j<m; ++j) dp[0][j] = j;

        for(int j = 1; j<m; ++j){
            for(int i = 1; i<n; ++i){
                int insert = dp[i][j-1] + 1;
                int delete = dp[i-1][j] + 1;
                int replace = dp[i-1][j-1] + 1;
                int match = dp[i-1][j-1];
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = Math.min(Math.min(insert, delete), match);
                else dp[i][j] = Math.min(Math.min(insert, delete), replace);
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }
}
