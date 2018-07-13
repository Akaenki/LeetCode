import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueReconstruction {
    /** sort of cheating */
    public static int[][] reconstructQueue(int[][] people) {
        if(people.length == 0) return new int[0][0];
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        for(int[] p : people) queue.offer(p);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            result.add(cur[1], cur);
        }
        return result.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = reconstructQueue(people);
        for(int i = 0; i<result.length; ++i){
            System.out.print("["+result[i][0]+", "+result[i][1]+"] ");
        }
    }
}
