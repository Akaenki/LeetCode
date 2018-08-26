public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] root = new int[edges.length + 1];
        int[] e1 = new int[]{-1,-1}, e2 = new int[]{-1,-1};
        // first find the two edges have the same root if there's any
        for(int i = 0; i<edges.length; ++i){
            if(root[edges[i][1]] == 0) root[edges[i][1]] = edges[i][0];
            else {
                // e1 appears latter then e2
                e1 = new int[]{edges[i][0], edges[i][1]}; e2 = new int[]{root[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }

        for(int i = 0; i<root.length; ++i) root[i] = i;

        for(int[] edge : edges){
            // skip the latter one (e1)
            if(edge[1] == 0) continue;
            // find the loop;
            if(find(root, edge[1]) == edge[0]){
                // if there's no two edges with the same root, this is the only fault edge
                if(e2[0] == -1) return edge;
                // otherwise return the second one
                return e2;
            }
            root[edge[1]] = edge[0];
        }

        return e1;
    }

    private int find(int[] root, int n){
        while(n != root[n]) n = root[n];
        return n;
    }
}
