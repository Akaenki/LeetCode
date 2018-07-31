public class LongestSubstringKRepeat {
    public int longestSubstring(String s, int k) {
        return search(s.toCharArray(), 0, s.length(), k);
    }

    private int search(char[] str, int start, int end, int k){
        if(end - start < k) return 0;
        int[] hash = new int[end-start];
        for(int i = start; i<end; ++i) hash[str[i]-'c']++;

        for(int i = start; i<end; ++i){
            int idx = str[i]-'a';
            if(hash[idx]!=0 && hash[idx] < k){
                int left = search(str, start, i, k),
                        right = search(str, i+1, end, k);
                return Math.max(left, right);
            }
        }
        return end-start;
    }
}
