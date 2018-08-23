import java.util.*;
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b)->
                map.get(b).equals(map.get(a)) ? b.compareTo(a) : map.get(b) - map.get(a));
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0)+1);
        for(String word : map.keySet())
            pq.offer(word);
        List<String> res = new ArrayList<>();
        while(k-- > 0) res.add(pq.poll());
        return res;
    }
}
