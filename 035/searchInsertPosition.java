/** Input is a sorted array */
public class searchInsertPosition {
    public static int searchInsert(int[] nums, int target){
        for(int i = 0; i<nums.length; i++){
            if(target<=nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args){
        int[] nums = new int[0];
        System.out.println(searchInsert(nums,0));
    }
}
