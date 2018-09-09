import java.util.*;

public class Contest100 {
    public boolean monotonicArray(int[] nums) {
        if (nums.length < 3) return true;
        int diff = nums[0] - nums[nums.length - 1];
        for (int i = 0; i < nums.length - 1; ++i) {
            int cur = nums[i] - nums[i + 1];
            if (diff == 0 && cur != 0) return false;
            if (diff > 0 && cur < 0) return false;
            if (diff < 0 && cur > 0) return false;
        }
        return true;
    }

    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> res = new HashSet<>(), prev = new HashSet<>();
        for(int a : A){
            HashSet<Integer> cur = new HashSet<>();
            cur.add(a);
            for(int p : prev) cur.add(p | a);
            prev = cur;
            for(int p : prev) res.add(p);
        }
        return res.size();
    }

    public String orderlyQueue(String S, int K) {
        if(K == 1) {
            String res = S;
            for (int i = 0; i < S.length(); ++i) {
                String cur = S.substring(i, S.length()) + S.substring(0, i);
                if (cur.compareTo(res) < 0) res = cur;
            }
            return res;
        } else{
            int[] hash = new int[26];
            for(char c : S.toCharArray()) hash[c-'a']++;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<26; ++i){
                while(hash[i]-- > 0) {
                    sb.append((char) (i + 'a'));
                }
            }
            return sb.toString();
        }
    }


    public int largestRectangleArea(int[] heights) {
        int[][] arr = new int[heights.length][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        for(int i = 0; i<heights.length; ++i){
            arr[i] = new int[]{i, heights[i]};
            pq.offer(arr[i]);
        }

        int left = 0, right = arr.length-1, max = 0;
        while(left < right){
            int cur = Math.min(pq.peek()[1], Math.min(heights[left], heights[right])) * (right-left+1);
            max = Math.max(cur, max);
            if(heights[left] < heights[right])
                pq.remove(arr[left++]);
            else pq.remove(arr[right--]);

        }
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] res= new int[nums.length-k+1];
        for(int i = 0; i<nums.length; ++i){
            if(dq.isEmpty() || dq.getLast() >= nums[i]) {
                dq.addLast(i);
                if(dq.getFirst() <= i-k) dq.removeFirst();
            } else{
                dq.clear();
                dq.addLast(i);
            }
            if(i >= k-1)
                res[i-k+1] = dq.getFirst();
        }
        return res;
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        List<int[]> list = new ArrayList<>();
        for(int[] p : people) list.add(p[1],p);
        return list.toArray(new int[people.length][2]);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer>[] bucket = new List[nums.length+1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = nums.length; i>=0; --i){
            if(bucket[i] == null) continue;
            res.addAll(bucket[i]);
            if(res.size() >= k) break;
        }
        return res;
    }

    public List<List<String>> topKgpa(List<List<String>> list, int k) {
        if(k >= list.size()) return list;
        Collections.sort(list, (a, b)->Double.compare(Double.parseDouble(b.get(1)),Double.parseDouble(a.get(1))));
        return list.subList(0, k);
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();

    }

}
