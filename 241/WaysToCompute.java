import java.util.*;
public class WaysToCompute {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<input.length(); ++i){
            char c = input.charAt(i);
            if(c == '-' || c == '+' || c == '*'){
                String prev = input.substring(0,i), post = input.substring(i+1, input.length());
                List<Integer> left = map.containsKey(prev) ? map.get(prev) : diffWaysToCompute(prev),
                        right = map.containsKey(post) ? map.get(post) : diffWaysToCompute(post);
                for(int l : left){
                    for(int r : right) {
                        if (c == '-') res.add(l - r);
                        else if (c == '+') res.add(l + r);
                        else res.add(l * r);
                    }
                }
            }
        }
        if(res.isEmpty()) res.add(Integer.parseInt(input));
        map.put(input, res);
        return res;
    }
}
