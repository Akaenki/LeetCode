import java.util.Arrays;

public class majorityElement {
    public static int majorityElement(int[] nums) {
        /** Easiest way but bounded by the sorting method,
         *  which is at best O(nlogn) time */
        //Arrays.sort(nums);
        //return nums[nums.length/2];
        int maj = nums[0]; int count = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == maj) count += 1;
            else count -= 1;
            if(count == 0) maj = nums[i];
        }
        return maj;
    }
}
