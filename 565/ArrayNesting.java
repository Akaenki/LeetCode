import java.util.*;
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) cycle(nums, n, set);
        return set.size();
    }

    private void cycle(int[] nums, int start, HashSet<Integer> set){
        if(set.contains(start)) return;
        HashSet<Integer> cur = new HashSet<>();
        while(cur.add(start)){
            start = nums[start];
        }
        if(cur.size() > set.size()) set = cur;
    }
}
