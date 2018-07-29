import java.util.*;
public class PyramidTransition {
    HashMap<String, List<Character>> map = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for(String s : allowed){
            String pf = s.substring(0,2);
            if(!map.containsKey(pf))
                map.get(pf).add(s.charAt(2));
            else map.put(pf, new ArrayList<>(Collections.singletonList(s.charAt(2))));
        }
        return build(bottom, "", 0, map);
    }

    private boolean build(String bottom, String cur, int next, HashMap<String, List<Character>> map){
        if(bottom.length() == 1) return true;
        if(next >= bottom.length()-1) return build(cur, "", 0, map);
        String pf = "" + bottom.charAt(next) + bottom.charAt(next+1);
        if(!map.containsKey(pf)) return false;
        List<Character> candidates = map.get(pf);
        for(char c : candidates){
            if(build(bottom, cur+c, next+1, map)) return true;
        }
        return false;
    }
}
