import java.lang.reflect.Array;
import java.util.Arrays;

public class DuplicateSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        if(target > nums[nums.length-1] || target < nums[0]) return new int[]{-1,-1};
        int[] interval = new int[2];
        int l = 0, h = nums.length;
        while(l < h){
            int m = (l + h) / 2;
            if(target <= nums[m]) h = m;
            else l = m + 1;
        }
        if(target != nums[l]) return new int[]{-1,-1};
        interval[0] = l;

        h = nums.length - 1;
        while(l < h) {
            int m = (l + h) / 2 + 1;
            if (target < nums[m]) h = m - 1;
            else l = m;
        }
        interval[1] = h;

        return interval;
    }


    public static void main(String[] args) {
        int[] input = new int[]{1,1,1};
        System.out.println(Arrays.toString(searchRange(input, 1)));
    }
}
