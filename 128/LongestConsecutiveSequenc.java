import java.util.HashMap;

public class LongestConsecutiveSequenc {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int max = 0;
        for(int n : nums){
            if(!hash.containsKey(n)){
                int left = hash.containsKey(n-1) ? hash.get(n-1) : 0;
                int right = hash.containsKey(n+1) ? hash.get(n+1) : 0;
                int total = left + right + 1;
                hash.put(n, total);
                hash.put(n - left, total);
                hash.put(n + right, total);
                max = Math.max(max, total);
            }
        }
        return max;
    }
}
