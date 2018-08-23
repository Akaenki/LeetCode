import java.util.HashSet;
import java.util.PriorityQueue;

public class OpenLock {
    class LockState{
        String str;
        int dist = 0, steps;
        LockState(String str, int steps){
            this.str = str; this.steps = steps;
            for(char c : str.toCharArray()) dist += Math.min(c-'0',10-(c-'0'));
        }
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        for(String str : deadends) set.add(str);
        PriorityQueue<Solution.LockState> pq = new PriorityQueue<>((a, b)->a.dist-b.dist);
        pq.offer(new Solution.LockState(target, 0));
        while(!pq.isEmpty()){
            Solution.LockState ls = pq.poll();
            char[] lock = ls.str.toCharArray();
            for(int i = 0; i<4; ++i){
                char c = lock[i];
                lock[i] = (char)(Math.floorMod(c-'0'-1, 10) + '0');
                String next = new String(lock);
                if(!set.contains(next)) {
                    if(next.equals("0000")) return ls.steps+1;
                    pq.offer(new Solution.LockState(next, ls.steps + 1));
                    set.add(next);
                }
                lock[i] = (char)(Math.floorMod(c-'0'+1, 10) + '0');
                next = new String(lock);
                if(!set.contains(next)) {
                    if (next.equals("0000")) return ls.steps + 1;
                    pq.offer(new Solution.LockState(next, ls.steps + 1));
                    set.add(next);
                }
                lock[i] = c;
            }
        }
        return -1;
    }
}
