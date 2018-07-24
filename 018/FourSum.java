import java.util.*;
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-3; ++i){
            int k = target;
            //too large: end the scan
            if((nums[i]+nums[i+1]+nums[i+2]+nums[i+3])>k) break;
            //too small: continue to next start
            if((nums[i]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1])<k) continue;
            if(i>0 && nums[i] == nums[i-1]) continue;
            k -= nums[i];
            for(int j = i+1; j<nums.length-2; ++j){
                if((nums[j] + nums[j+1] + nums[j+2])>k) break;
                if((nums[j] + nums[nums.length-2] + nums[nums.length-1])<k) continue;
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                k -= nums[j];
                int start = j+1, end = nums.length-1;
                while (start < end){
                    if(nums[start] + nums[end] == k) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start - 1]) start++;
                        while (start < end && nums[end] == nums[end + 1]) end--;
                        start++;end--;
                    } else if(nums[start] + nums[end] > k) end--;
                    else start++;
                }
                k += nums[j];
            }
            k += nums[i];
        }
        return res;
    }
}
