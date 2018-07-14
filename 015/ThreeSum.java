import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; ++i){
            if(nums[i] > 0) break;
            if(i == 0 || nums[i] != nums[i-1]){
                //Sorted array two sum
                int sum = -nums[i];
                int start = i+1, end = nums.length-1;
                while (start < end){
                    if(nums[start] + nums[end] == sum) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        start++;end--;
                        while (start < end && nums[start] == nums[start - 1]) start++;
                        while (start < end && nums[end] == nums[end + 1]) end--;
                    } else if(nums[start] + nums[end] > sum) end--;
                    else start++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum o = new ThreeSum();
        System.out.println(o.threeSum(nums).toString());
    }

}
