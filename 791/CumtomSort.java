import java.util.*;
public class CumtomSort {
    public String customSortString(String S, String T) {
        int[] hash= new int[26];
        for(char c : T.toCharArray()) hash[c-'a']++;
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()) {
            while (hash[c - 'a']-- > 0) sb.append(c);
        }
        for(int i = 0; i<26; ++i) {
            while (hash[i]-- > 0) sb.append(i + 'a');
        }
        return sb.toString();
    }
}
