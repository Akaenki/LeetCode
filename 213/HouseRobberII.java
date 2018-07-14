public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        /* Exclude the last one */
        int a = 0, b = 0;
        for(int i = 0; i<nums.length-1; ++i){
            int temp = b;
            b = Math.max(a + nums[i], b);
            a = temp;
        }
        /* Exclude the first one */
        int a1 = 0, b1 = 0;
        for(int i = 1; i<nums.length; ++i){
            int temp = b1;
            b1 = Math.max(a1 + nums[i], b1);
            a1 = temp;
        }
        return Math.max(Math.max(a,b),Math.max(a1,b1));
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,1,1,10,2,9};
        HouseRobberII o = new HouseRobberII();
        System.out.println(o.rob(input));
    }
}
