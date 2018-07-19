import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedulerII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses], res = new int[numCourses];
        for(int i = 0; i<numCourses; i++) graph[i] = new ArrayList();
        for(int[] p : prerequisites){
            graph[p[0]].add(p[1]); degree[p[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0, ptr = numCourses-1;
        /* Count unconnected vertices */
        for(int i = 0; i<numCourses; ++i){
            if(degree[i] == 0){
                count++; q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll(); res[ptr--] = cur;
            for(int i = 0; i<graph[cur].size(); ++i){
                int req = (int) graph[cur].get(i);
                degree[req]--;
                if(degree[req] == 0){
                    count++; q.offer(req);
                }
            }
        }
        return count == numCourses? res : new int[0];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[] out = findOrder(4, input);

        for(int i : out) System.out.print(i + " ");
    }
}
