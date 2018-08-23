import java.util.*;
public class FindLogestWord {
    public String findLongestWord(String s, List<String> d) {
    Collections.sort(d, (a, b)->a.length()==b.length()?a.compareTo(b):a.length()-b.length());
    for(String str : d){
        int ptr = 0;
        for(char c : s.toCharArray()){
            if(c == str.charAt(ptr)) ptr++;
            if(ptr >= str.length()) return str;
        }
    }
    return "";
}
}
