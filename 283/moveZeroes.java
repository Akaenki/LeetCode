public class moveZeroes {
    public static void moveZeroes(int[] nums){
        int ptr = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0) nums[ptr++] = nums[i];
        }

        for(int i = ptr; i<nums.length; i++)
            nums[i] = 0;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,0,1,0,3,12,0};
        moveZeroes(nums);
        for(int i : nums)
            System.out.print(i + " ");
    }
}
