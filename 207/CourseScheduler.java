import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class CourseScheduler {

    /** BFS,  */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length < 2) return true;
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        for(int i = 0; i<numCourses; i++) graph[i] = new ArrayList();
        for(int[] p : prerequisites){
            graph[p[0]].add(p[1]); degree[p[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        /* Count unconnected vertices */
        for(int i = 0; i<numCourses; ++i){
            if(degree[i] == 0){
                count++; q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i<graph[cur].size(); ++i){
                int req = (int) graph[cur].get(i);
                degree[req]--;
                if(degree[req] == 0){
                    count++; q.offer(req);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] req = new int[][]{{0, 1}, {1, 2}, {1, 0}};
        System.out.println(canFinish(3, req));
    }
}
