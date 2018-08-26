import java.util.HashSet;
import java.util.Set;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] root = new int[n];
        for(int i = 0; i<n; ++i) root[i] = i;

        int res = n;
        for(int i = 0; i<n; ++i){
            for(int j = i+1; j<n; ++j){
                if(M[i][j] == 1){
                    int a = find(root, i),
                            b = find(root, j);
                    if(a != b){ root[j] = i; res--; }
                }
            }
        }

        Set<Integer> roots = new HashSet<>();
        for(int r : root) roots.add(r);
        return roots.size();
    }

    private int find(int[] root, int n){
        while(root[n] != n) n = root[n];
        return n;
    }
}
