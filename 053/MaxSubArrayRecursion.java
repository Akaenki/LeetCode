import java.util.Arrays;

public class MaxSubArrayRecursion {
    /* Divide and conquer. Only for practice and fun */
    public static int maxSubArray(int[] nums) {
        if(nums.length <= 1) return nums[0];
        int mid = nums.length/2, leftsum = Integer.MIN_VALUE, rightsum = Integer.MIN_VALUE,
                crosssum = Integer.MIN_VALUE;
        int left = maxSubArray(Arrays.copyOfRange(nums,0,mid));
        int right = maxSubArray(Arrays.copyOfRange(nums, mid, nums.length));

        int sum = 0;
        for(int i = mid; i<nums.length; ++i){
            sum += nums[i];
            rightsum = Math.max(rightsum, sum);
        }
        sum = 0;
        for(int i = mid-1; i>=0; --i){
            sum += nums[i];
            leftsum = Math.max(sum, leftsum);
        }

        crosssum = leftsum + rightsum;
        return Math.max(Math.max(left, right), crosssum);
    }

    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
