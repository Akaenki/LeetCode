import java.util.*;


public class Contest99 {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int sum = 0;
        for(int i = 0; i<n; ++i){
            for(int j = 0; j<n; ++j){
                int cur = grid[i][j] == 0 ? 0 : grid[i][j]*6 - 2*(grid[i][j]-1);
                sum += cur;
                if(i > 0) sum -= Math.min(grid[i][j], grid[i-1][j]) * 2;
                if(j > 0) sum -= Math.min(grid[i][j], grid[i][j-1]) * 2;
            }
        }
        return sum;
    }

    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for(String str : A){
            int[] odd = new int[26], even = new int[26];
            for(int i = 0; i<str.length(); ++i){
                if(i % 2 == 1) odd[str.charAt(i)-'a']++;
                else even[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<26; ++i){
                if(odd[i] == 0) continue;
                sb.append((char)(i+'a')).append(odd[i]);
            }
            for(int i = 0; i<26; ++i){
                if(even[i] == 0) continue;
                sb.append((char)(i+'a')).append(even[i]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N == 1){
            res.add(new TreeNode(0));
            return res;
        }

        for(int l = 1; l < N-1; l+=2){
            List<TreeNode> left = allPossibleFBT(l), right = allPossibleFBT(N-1-l);
            for(TreeNode tl : left){
                for (TreeNode tr : right){
                    TreeNode root = new TreeNode(0);
                    root.left = tl; root.right = tr;
                    res.add(root);
                }
            }
        }
        return res;
    }

    private TreeNode copy(TreeNode root){
        if(root == null) return null;
        TreeNode copy = new TreeNode(0);
        copy.left = copy(root.left);
        copy.right = copy(root.right);
        return copy;
    }

    class FreqStack {

        PriorityQueue<int[]> pq;
        Map<Integer, Integer> map;
        int time;

        public FreqStack() {
            pq = new PriorityQueue<>((a,b) -> (a[1] == b[1]) ? b[2] - a[2] : b[1] - a[1]);
            map = new HashMap<>();
            time = 0;
        }

        public void push(int x) {
            time++;
            int cnt = map.getOrDefault(x, 0) + 1;
            map.put(x, cnt);
            pq.add(new int[]{x, cnt, time});
        }

        public int pop() {
            int[] res = pq.poll();
            return res[0];
        }
    }
}
