import java.util.*;
public class Pinterest {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q),
                right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; ++i)
            for(int j = 0; j<n; ++j)
                dp[i][j] = -1;
        int max = 0;
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                int cur = dfs(matrix, i, j, dp, matrix[i][j]-1);
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp, int prev){
        if(i < 0 || j < 0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j] <= prev) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int a1 = dfs(matrix, i+1, j, dp, matrix[i][j]), a2 = dfs(matrix, i-1, j, dp, matrix[i][j]),
                a3 = dfs(matrix, i, j+1, dp, matrix[i][j]), a4 = dfs(matrix, i, j-1, dp, matrix[i][j]);
        dp[i][j] = 1 + Math.max(Math.max(a1, a2), Math.max(a3, a4));
        return dp[i][j];
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }

    public Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null) return new Pair(0, null);
        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);

        int d1 = l.getKey(), d2 = r.getKey();
        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.size(); ++i){
            // number value, index of list, index of number in the list
            pq.offer(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int minlen = Integer.MAX_VALUE, minstart = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int[] min = pq.poll();
            if(max - min[0] < minlen){
                minlen = max - min[0];
                minstart = min[0];
            }
            int listid = min[1], entryid = min[2];
            if(entryid >= nums.get(listid).size()-1) //end of search
                return new int[]{minstart, minstart+minlen};
            pq.offer(new int[]{nums.get(listid).get(entryid+1), listid, entryid+1});
            max = Math.max(max, nums.get(listid).get(entryid+1));
        }
        return new int[]{minstart, minstart+minlen};
    }

    public String alienOrder(String[] words) {
        int[] hash = new int[26];
        for(String word : words)
            for(char c : word.toCharArray()) hash[c-'a']++;
        ArrayList<Character>[] graph = new ArrayList[26];
        int[] degree = new int[26];
        for(int i = 1; i<words.length; ++i){
            for(int j = 0; j<words[i].length() && j<words[i-1].length(); ++j){
                char a = words[i-1].charAt(j), b = words[i].charAt(j);
                if(a != b){
                    degree[b-'a'] += 1;
                    if(graph[a-'a'] == null) graph[a-'a'] = new ArrayList<>();
                    graph[a-'a'].add(b);
                    break;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        int total = 0;
        for(int i = 0; i<26; ++i){
            if(hash[i] != 0) total++;
            if(hash[i] != 0 && degree[i] == 0) q.offer((char)(i+'a'));
        }
        while(!q.isEmpty()){
            char cur = q.poll();
            res.append(cur);
            if(graph[cur-'a'] == null) continue;
            for(int i = 0; i<graph[cur-'a'].size(); ++i){
                char nb = graph[cur-'a'].get(i);
                degree[nb-'a']--;
                if(degree[nb-'a'] == 0) q.offer(nb);
            }
        }
        return res.length() == total ? res.toString() : "";
    }


    private Queue<Long> small = new PriorityQueue(),
            large = new PriorityQueue();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }


    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 3) return result;
        helper(n, -1, result, new ArrayList<Integer>());
        return result;
    }

    public void helper(int n, int lower, List<List<Integer>> result, List<Integer> cur) {
        if (lower != -1) {
            cur.add(n);
            result.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);
        }
        int upper = (int) Math.sqrt(n);
        for (int i = Math.max(2, lower); i <= upper; ++i) {
            if (n % i == 0) {
                cur.add(i);
                helper(n / i, i, result, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1]; dp[0] = true;
        for(int i = 1; i<=s.length(); ++i){
            for(int j = 0; j<i; ++j){
                if(!dp[j]) continue;
                String key = s.substring(j, i);
                if(set.contains(key)) dp[i] = true;
            }
        }
        return dp[s.length()];
    }

    public int findCelebrity(int n) {
        int cur = 0;
        for(int i = 1; i<n; ++i){
            if(knows(cur, i)) cur = i;
        }

        for(int i = 0; i<n; ++i){
            if(cur!=i && (!knows(i, cur) || knows(cur, i)))
                return -1;
        }
        return cur;
    }

}
