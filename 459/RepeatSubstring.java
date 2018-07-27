public class RepeatSubstring {
    /** The Knuth-Morris-Pratt Algorithm
     *  The value array stores the longest prefix */
    public boolean repeatedSubstringPattern(String s) {
        int[] value = new int[s.length()];
        char[] str= s.toCharArray();
        value[0] = 0;
        int start = 0, end = 1;
        while(end < s.length()){
            if(str[start] == str[end]){
                value[end++] = ++start;
            } else {
                if(start == 0) value[end++] = 0;
                else start = value[start - 1];
            }
        }
        int len = value[s.length()-1];
        return (len > 0) && (s.length()%(s.length()-len) == 0);
    }
}
