import java.util.*;

public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        for(char c : S.toCharArray()) hash[c-'1']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[1] - a[1]);
        for(int i = 0; i<26; ++i){
            if(hash[i] == 0) continue;
            pq.offer(new int[]{i + 'a', hash[i]});
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = new int[]{-1, -1};
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(prev[1] > 1) pq.offer(prev);
            sb.append((char)cur[0]);
            prev = cur;
            if(--prev[0] > 0 && pq.isEmpty()) return "";
        }
        return sb.toString();
    }
}
