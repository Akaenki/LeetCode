public class RegularExpressionMatching {
    /** If ptn[j] = '.' OR ptn[j] = str[i], counts as direct match return dp[i-1][j-1]
     *  If ptn[j] = '*' AND ptn[j-1] = str[i], a* counts as multiple a return dp[i-1][j]
     *                  AND ptn[j-1] != str[i], a* counts as empty return dp[i][j-2]
     *                  AND ptn[j-1] = str[i-1], a* counts as single a return dp[i][j-1];
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        dp[0][0] = true;
        for(int i = 1; i<p.length(); ++i){
            if(p.charAt(i) == '*') dp[0][i+1] = dp[0][i-1];
        }
        for(int i = 0; i<s.length(); ++i){
            for(int j = 0; j<p.length(); ++j){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') dp[i+1][j+1] = dp[i][j];
                if(p.charAt(j) == '*'){
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.')
                        dp[i+1][j+1] = dp[i+1][j-1];

                    else dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
