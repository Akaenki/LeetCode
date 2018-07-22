public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] hash = new int[256], map = new int[256];
        for(char c : t.toCharArray()) hash[c]++;

        int start = 0, counter = t.length(), min = Integer.MAX_VALUE;
        for(int i = 0; i<s.length(); ++i){
            if(hash[s.charAt(i)]-- > 0) counter--;
            while(counter == 0){
                min = Math.min(min, i - start);
                if(++hash[s.charAt(start)] > 0) counter++;
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start-1, start+min-1);
    }
}
