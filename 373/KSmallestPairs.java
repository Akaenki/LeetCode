import java.util.*;
public class KSmallestPairs {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<int[]> res = new ArrayList<>();
        if(m == 0 || n == 0) return res;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[0] - b[0]);
        for(int i = 0; i<n; ++i) q.offer(new int[]{nums1[0]+nums2[i], 0, i});
        while(k-- > 0 && !q.isEmpty()){
            int[] cur = q.poll();
            if(cur[1]+1 < m)
                q.offer(new int[]{nums1[cur[1]+1]+nums2[cur[2]], cur[1]+1, cur[2]});
            res.add(new int[]{nums1[cur[1]], nums2[cur[2]]});
        }
        return res;
    }
}
