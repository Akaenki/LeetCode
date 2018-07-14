import java.util.*;

public class KFrequentElements {
    /** All the operations used for Hash Map and Max Heap(PQ) are O(logn)
     *  Overall O(nlogn) */
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        PriorityQueue<Map.Entry> queue = new PriorityQueue<>(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return (int)o2.getValue() - (int)o1.getValue();
            }
        });
        for(Map.Entry m : map.entrySet())
            queue.offer(m);
        List<Integer> result = new ArrayList<>();
        while(k-- > 0){
            result.add((int)queue.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        KFrequentElements kf = new KFrequentElements();
        int[] input = new int[]{1,1,1,2,2,3,1,4,4,5,6,2};
        System.out.println(kf.topKFrequent(input, 4).toString());
    }
}
