import java.util.PriorityQueue;

public class KthSmallestSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n = matrix.length;
        for(int i = 0; i<n; ++i) q.offer(new int[]{matrix[0][i], 0, i});
        while(k-- > 1){
            int[] cur = q.poll();
            if(cur[1]<n-1) q.offer(new int[]{matrix[cur[1]+1][cur[2]], cur[1]+1,cur[2]});
        }
        return q.poll()[0];
    }

    /** Binary Search */
    public int kthSmallest2(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
