public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        String res = ""; int max = 0;
        /** track the longest palindrome in the substring[0..i] */
        for(int i = 0; i<s.length(); ++i){
            if(valid(s, i - max - 1, i)){
                res = s.substring(i-max-1, i+1);
                max += 2;
            } else if(valid(s, i-max, i)){
                res = s.substring(i-max, i+1);
                max += 1;
            }
        }
        return res;
    }

    private boolean valid(String s, int head, int tail){
        if(head < 0) return false;
        while(head < tail){
            if(s.charAt(head++) != s.charAt(tail--)) return false;
        }
        return true;
    }
}
