import java.util.*;
public class SmallerNumbersAfterSelf {
    /** Counting inversions, using mergesort.
     * If a number int a position is swapped with a number after it,
     * increase the count at that position */
    public List<Integer> countSmaller(int[] nums) {
        int[] counts = new int[nums.length], idx = new int[nums.length];
        for(int i = 0; i<nums.length; ++i) idx[i] = i;

        merge(nums, counts, idx, 0, nums.length-1);

        List<Integer> res = new ArrayList<>();
        for(int c : counts) res.add(c);
        return res;
    }

    private void merge(int[] nums, int[] counts, int[] idx, int lo, int hi){
        if(hi <= lo) return;
        int mid = (lo + hi)/2;
        merge(nums, counts, idx, lo, mid);
        merge(nums, counts, idx, mid+1, hi);

        int left = lo, right = mid+1, ptr = lo, count = 0;
        int[] aux = new int[nums.length];
        while(left <= mid && right <= hi){
            if(nums[idx[right]] < nums[idx[left]]){
                aux[ptr++] = idx[right++];
                count++;
            } else{
                aux[ptr] = idx[left];
                counts[idx[left]] += count;
                ptr++; left++;
            }
        }
        while(left <= mid){
            aux[ptr] = idx[left];
            counts[idx[left]] += count;
            ptr++; left++;
        }

        while(right <= hi){
            aux[ptr] = idx[right];
            ptr++; right++;
        }

        for(int i = lo; i<=hi; ++i) idx[i] = aux[i];
    }


    public static void main(String[] args) {

    }

}
