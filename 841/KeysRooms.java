import java.util.*;

public class KeysRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() < 2) return true;
        int[] hash = new int[rooms.size()];
        boolean[] visited = new boolean[rooms.size()];
        hash[0]++; visited[0] = true;
        Queue<Integer> keys = new LinkedList<>();
        keys.offer(0);
        while(!keys.isEmpty()){
            int cur = keys.poll();
            if(visited[cur]) continue;
            for(int key : rooms.get(cur)){
                if(hash[key]++ == 0) keys.offer(key);
            }
            visited[cur] = true;
        }

        for(int i = 0; i<rooms.size(); ++i){
            if(!visited[i]) return false;
        }
        return true;
    }
}
