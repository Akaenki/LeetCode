import java.util.*;
public class SubstringConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        int len = words[0].length(), n = words.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<s.length()-n*len; i++){
            HashMap<String, Integer> visited = new HashMap<>(map);
            for(int j = 0; j<n; ++j){
                String cur = s.substring(i + j*len, i + j*n + len);
                if(visited.containsKey(cur)){
                    if(visited.get(cur) <= 1) visited.remove(cur);
                    else visited.put(cur, visited.get(cur)-1);

                    if(visited.isEmpty()) res.add(i);
                } else break;
            }
        }
        return res;
    }
}
