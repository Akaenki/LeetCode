import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumRefueling {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target <= startFuel) return 0;
        if(stations.length == 0) return -1;
        int count = 0, fuel = startFuel, prev = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { return o2[1] - o1[1]; }
        });
        for(int i = 0; i<stations.length; ++i){
            fuel -= stations[i][0] - prev;
            while(fuel < 0 && !queue.isEmpty()){
                fuel += queue.poll()[1];
                count++;
            }
            if(fuel < 0) return -1;
            queue.offer(stations[i]);
            prev = stations[i][0];
        }

        fuel -= target - prev;
        while(fuel < 0 && !queue.isEmpty()){
            fuel += queue.poll()[1];
            count++;
        }
        if(fuel < 0) return -1;
        return count;
    }

    public static void main(String[] args) {
        int[][] stations = new int[][]{{10,60}, {20,30}, {30,30}, {60,40}};
        System.out.println(minRefuelStops(100, 10, stations));
    }
}
