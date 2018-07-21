public class JumpGameII {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int steps = 1;
        for(int i = 0; i<nums.length-1;){
            int pmax = i + nums[i];
            if(pmax >= nums.length-1) return steps;
            int max = pmax + nums[pmax], next = pmax;
            for(int j = i+1; j<pmax; ++j){
                if(j+nums[j] > max){
                    max = Math.max(max, j+nums[j]);
                    next = j;
                }
            }
            i = next; steps++;
        }
        return steps;
    }
}
