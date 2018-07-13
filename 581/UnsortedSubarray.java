public class UnsortedSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int left = 0, right = 0, max = Integer.MAX_VALUE;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] < nums[i-1] && max == Integer.MAX_VALUE){
                max = nums[i - 1];
                left = i-1; right = i + 1;
            } else if(nums[i] < nums[i-1]){
                right = i + 1;
                max = Math.max(max, nums[i-1]);
            }

            if(max != Integer.MAX_VALUE){
                while(left != 0 && nums[i] < nums[left-1]){
                    left -= 1;
                }

                if(nums[i] < max) right = i + 1;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,2,3,4,5,6,7,7,8};
        System.out.println(findUnsortedSubarray(nums));
    }
}
