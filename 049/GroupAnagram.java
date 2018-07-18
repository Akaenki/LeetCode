import java.util.*;
public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> hash = new HashMap<>();
        for(String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            if(!hash.containsKey(key))
                hash.put(key, new ArrayList<>());
            hash.get(key).add(str);
        }
        return new ArrayList<>(hash.values());
    }

    public static void main(String[] args) {
        String[] input = new String[]{};
        System.out.println(groupAnagrams(input).toString());
    }
}
