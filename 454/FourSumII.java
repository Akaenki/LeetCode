import java.util.*;

public class FourSumII {
    /* Adapt from 2sum */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length, count = 0;
        if(n == 0) return count;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; ++i) {
            for(int j = 0; j<n; ++j) {
                map.put(A[i] + B[i], map.getOrDefault(A[i] + B[i], 0) + 1);
            }
        }

        for(int i = 0; i<n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (map.containsKey(C[i] + D[j]))
                    count += map.get(C[i] + D[j]);
            }
        }
        return count;
    }
}
