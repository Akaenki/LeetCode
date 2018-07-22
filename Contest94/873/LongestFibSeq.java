package Contest94;

import java.util.HashMap;

public class LongestFibSeq {
    public int lenLongestFibSubseq(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<A.length; ++i){
            map.put(A[i], 1);
        }
        int max = 0;
        for(int i = 0; i<A.length-1; ++i){
            int count = 0;
            for(int j = i+1; j<A.length; ++j){
                int next = A[i] + A[j];
                int prev = A[j];
                while(next <= A[A.length-1] && map.containsKey(next)){
                    count++;
                    next = next + prev;
                    prev = next - prev;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
