public class HouseRobber {
    public static int rob(int[] nums) {
        int[] sum = new int[nums.length];
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length < 3) return Math.max(nums[0], nums[1]);
        for(int i = 0; i<nums.length; ++i){
            if(i < 2) sum[i] = nums[i];
            else if(i == 2) sum[i] = nums[i] + sum[i-2];
            else sum[i] = nums[i] + Math.max(sum[i-2], sum[i-3]);
        }
        return Math.max(sum[nums.length-1], sum[nums.length-2]);
    }

    /* Can get rid of the extra spaces */
    public static int rob2(int[] nums) {
        int a = 0, b = 0;
        for(int n : nums){
            int temp = b;
            b = Math.max(a + n, b);
            a = temp;
        }
        return Math.max(a, b);
    }

    public static void main(String[] args){
        int[] nums = new int[]{9,1,1,9};
        System.out.println(rob2(nums));
    }

}
