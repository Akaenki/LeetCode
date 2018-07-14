public class PalindromicSubstring {
    public static int countSubstrings(String s) {
        int count = s.length();
        for(int i = 1; i<s.length(); ++i){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
                int left = i-1, right = i;
                while(--left>=0 && ++right<s.length()){
                    if(s.charAt(left) == s.charAt(right)) count++;
                    else break;
                }
            }
            if(i < s.length() - 1 && s.charAt(i-1) == s.charAt(i+1)){
                count++;
                int left = i-1, right = i+1;
                while(--left>=0 && ++right<s.length()){
                    if(s.charAt(left) == s.charAt(right)) count++;
                    else break;
                }
            }
        }
        return count;
    }

    /* Drop the unnecessary charAt access */
    public static int countSubstrings2(String s) {
        int count = 0;
        for(int i = 0; i<s.length(); ++i){
            int left = i, right = i + 1;
            while(left>=0 && right<s.length() && s.charAt(left--) == s.charAt(right++)) {
                count++;
            }
            left = i; right = i;
            while(left>=0 && right<s.length() && s.charAt(left--) == s.charAt(right++)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg";
        System.out.println(countSubstrings2(input));
        System.out.println(input.length());
    }
}
