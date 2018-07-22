public class SubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        int[] hash = new int[256];
        int[] dp = new int[s.length()+1];

        int max = 1;

        dp[0] = 0; dp[1] = 1; hash[s.charAt(0)] = 1;
        for(int i = 2; i<=s.length(); ++i){
            char c = s.charAt(i-1);
            if(hash[c] < 1)dp[i] = dp[i-1] + 1;
            else dp[i] = Math.min(i - hash[c],dp[i-1] + 1);
            max = Math.max(max, dp[i]);
            hash[c] = i;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdeeedcba"));
    }
}
