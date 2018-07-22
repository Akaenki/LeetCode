package Contest94;

import java.util.*;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] o : obstacles){
            if(!map.containsKey(o[0])) map.put(o[0], new HashSet<>());
            map.get(o[0]).add(o[1]);
        }
        int x = 0, y = 0, max = 0;
        int orient = 0; //0-top, 1-right, 2-bot, 3-left;
        int[][] orients = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i : commands){
            if(i == -2) orient = Math.floorMod(orient-1, 4);
            else if(i == -1) orient = Math.floorMod(orient+1, 4);
            else {
                int rest = 0;
                while(rest < i &&(!map.containsKey(x) || !map.get(x).contains(y))){
                    x+= orients[orient][0];
                    y+= orients[orient][1];
                    rest++;
                }
                if (map.containsKey(x) && map.get(x).contains(y)) {
                    x -= orients[orient][0];
                    y -= orients[orient][1];
                }
            }
            max = Math.max(max, x*x+y*y);
        }
        return max;
    }

}
