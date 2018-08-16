public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0) return "";
        int[] hash = new int[26];
        for(char c : s.toCharArray()) hash[c-'a']++;
        int min = 0;
        for(int i = 0; i<s.length(); ++i){
            if(s.charAt(i) < s.charAt(min)) min = i;
            if(--hash[s.charAt(i)-'a'] == 0) break;
        }
        char next = s.charAt(min);
        return next + removeDuplicateLetters(s.substring(min).replaceAll(next+"", ""));
    }
}
