import java.util.*;
public class AdvantageShuffle {
    public static int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] res= new int[A.length];
        PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i=0; i<A.length; i++) pq.add(new int[]{B[i], i});
        int lo=0, hi=A.length-1;
        while(!pq.isEmpty()){
            int[] cur= pq.poll();
            int idx=cur[1], val=cur[0];
            if (A[hi]>val) res[idx]=A[hi--];
            else res[idx]=A[lo++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,1,2,4,5};
        int[] b = new int[]{6,2,9,1,4};

        int[] out = advantageCount(a,b);
        for(int i:out)
            System.out.println(i + " ");
    }
}
