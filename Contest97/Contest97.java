import java.util.*;
public class Contest97 {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String a : A.split(" ")) map.put(a, map.getOrDefault(a, 0) + 1);
        for(String b : B.split(" ")) map.put(b, map.getOrDefault(b, 0) + 1);
        List<String> res = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == 1) res.add(key);
        }
        return res.toArray(new String[res.size()]);
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0, x = r0, y = c0, p = 1, count = 0, cur = 0;
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{x, y});
        x += dir[d][0]; y+= dir[d][1];
        while(res.size() < R*C){
            cur++;
            if(x >=0 && x < R && y >=0 && y < C) res.add(new int[]{x, y});
            if(cur == p){
                count++;
                if(count % 2 == 0) p++;
                cur = 0; d = (d+1) % 4;
            }
            x += dir[d][0]; y+= dir[d][1];
        }
        return res.toArray(new int[R][C]);
    }

    Map<Integer, Set<Integer>> map = new HashMap<>();
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(N < 3 || dislikes.length == 0) return true;
        for(int[] dislike : dislikes){
            if(!map.containsKey(dislike[0])) map.put(dislike[0], new HashSet<>());
            if(!map.containsKey(dislike[1])) map.put(dislike[1], new HashSet<>());
            map.get(dislike[0]).add(dislike[1]);
            map.get(dislike[1]).add(dislike[0]);
        }

        int[] set = new int[N+1];
        for(int i = 1; i<=N; ++i){
            if(!dfs(i, set, 1) && !dfs(i, set, -1)) return false;
        }
        return true;
    }

    private boolean dfs(int n, int[] set, int which){
        if(set[n] != 0) return set[n] == which;
        set[n] = which;
        for(int dis : map.get(n)){
            if(!dfs(dis, set, -1 * which)) return false;
        }
        return true;
    }

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for(int i = 1; i<= N; ++i) dp[1][i] = i;
        for(int i = 1; i<= N; ++i){
            for(int j = 1; j<=K; ++j){
                dp[i][j] = 1 + dp[j-1][i-1] + dp[j][i-1];
                if(dp[i][j] == N) return i;
            }
        }
        return -1;
    }

}
