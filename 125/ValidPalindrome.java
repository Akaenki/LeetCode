public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int l = 0, h = s.length() - 1;
        while(l <= h) {
            if (!Character.isLetterOrDigit(s.charAt(l))) l++;
            else if (!Character.isLetterOrDigit(s.charAt(h))) h++;
            else if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(h--)))
                    return false;
            }
        return true;
    }
}
