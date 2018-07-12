import java.util.LinkedList;
import java.util.List;
public class FindAnagrams {
    /* Using sliding window algorithm */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if(s.length()==0 || s.length() < p.length()) return result;
        /* build a hash table of the pattern string p */
        int[] hash = new int[256];
        for(char c : p.toCharArray()) hash[c]++;

        int left = 0, right = 0, count = p.length();
        while(right < s.length()){
            if(hash[s.charAt(right++)]-- > 0)
                count--;
            if(count == 0) result.add(left);
            if(right - left >= p.length() && hash[s.charAt(left++)]++ >= 0)
                count++;
        }
        return result;
    }

    /* Time Limit Exceed */
    public static List<Integer> findAnagrams0(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if(s.length()==0 || s.length() < p.length()) return result;
        for(int i = 0; i<=s.length()-p.length(); ++i){
            String scopy = p;
            int ptr = i;
            boolean isAnagram = true;
            while(!scopy.isEmpty()){
                char cur = s.charAt(ptr++);
                /* These build-in string methods are too expensive */
                if(scopy.contains(""+cur)){
                    int index = scopy.indexOf(""+cur);
                    scopy = scopy.substring(index+1) + scopy.substring(0,index);
                } else {
                    isAnagram = false; break;
                }
            }
            if(isAnagram) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab").toString());
    }
}
