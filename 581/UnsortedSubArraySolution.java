public class UnsortedSubArraySolution {
    /** A shorter and better solution from LeetCode Community */
    public static int findUnsortedSubarray(int[] nums) {
        int left = 0, right = -1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int l = 0, r = nums.length - 1; r>=0; l++, r--){
            max = Math.max(max, nums[l]);
            min = Math.min(min, nums[r]);
            if(nums[l] != max) right = l;
            if(nums[r] != min) left = r;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,2,3,4,5,6,7,7,8};
        System.out.println(findUnsortedSubarray(nums));
    }
}
