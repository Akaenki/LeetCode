import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) return intersect(nums2, nums1);
        if(nums2.length == 0) return new int[0];

       int[] res = new int[nums2.length]; int ptr = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int n : nums1){
            hash.put(n, hash.getOrDefault(n, 0) + 1);
        }

        for(int n : nums2){
            if(hash.containsKey(n) && hash.get(n) > 0){
                res[ptr++] = n; hash.put(n, hash.get(n)-1);
            }
        }
        return Arrays.copyOfRange(res, 0, ptr);
    }
}
