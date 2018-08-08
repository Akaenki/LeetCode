import java.util.*;
public class Contest96 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int bot = 0;
        int[] row = new int[n], col = new int[n];
        for(int i = 0; i<n; ++i){
            for(int j = 0; j<n; ++j){
                if(grid[i][j] > 0) bot++;
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int sum = bot;
        for(int r : row) sum+= r;
        for(int c : col) sum+= c;
        return sum;
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int l = 0, h = people.length;
        while(l < h){
            if(people[l] + people[h] > limit) {
                count++;
                h--;
            } else {
                count++;
                h--; l++;
            }
        }
        return l==h ? count+1:count;
    }

    public String decodeAtIndex(String S, int k) {
        char[] str = S.toCharArray();
        int ptr = 0, prev = 0;
        while(k > 0){
            char c = str[ptr];
            if(Character.isDigit(c)){
                int count = Character.getNumericValue(c);
                while(count-- > 1){
                    if(k - prev > 0) k-=prev;
                    else return decodeAtIndex(S, k);
                }
                prev = count*prev;
            } else {
                prev++; k--;
            }
            ptr++;
        }
        if(Character.isLetter(str[ptr-1])) return str[ptr-1]+"";
        else return str[0]+"";
    }

    public int reachableNodes(int[][] edges, int m, int n) {
        /** Weighted undirected graph */
        int[][] graph = new int[n][n];
        for(int i = 0; i<n; ++i) Arrays.fill(graph[i], -1);
        for(int[] edge : edges){
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }


        /** Dijkstra Algorithm */
        boolean[] marked = new boolean[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[1]-a[1]);
        q.offer(new int[]{0, m});
        int res = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(marked[cur[0]]) continue;
            marked[cur[0]] = true; res++;
            for(int i = 0; i<n; ++i){
                if(graph[cur[0]][i] > -1){
                    if(cur[1] > graph[cur[0]][i] && !marked[i])
                        q.offer(new int[]{i, cur[1]-graph[cur[0]][i]-1});
                    int visited = Math.min(cur[1], graph[cur[0]][i]);
                    graph[i][cur[0]] -= visited;
                    res += visited;
                }
            }

        }
        return res;
    }
}
