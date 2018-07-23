import java.util.*;

public class SkylineProblem {
    /** https://briangordon.github.io/2014/08/the-skyline-problem.html */
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> cps = new ArrayList<>();
        for(int[] b : buildings){
            cps.add(new int[]{b[0], b[2]});
            cps.add(new int[]{b[1], -b[2]});
        }
        Collections.sort(cps, (a, b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);

        List<int[]> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        queue.offer(0);
        for(int[] cp : cps){
            if(cp[1] > 0) queue.offer(cp[1]);
            else queue.remove(-cp[1]);

            int height = queue.peek();
            if(res.size() == 0 || height != res.get(res.size()-1)[1])
                res.add(new int[]{cp[0], height});
        }
        return res;
    }
}
