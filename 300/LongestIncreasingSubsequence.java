import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /** O(n^2) method */
    public static int lengthOfLIS(int[] nums) {
        if(nums.length < 2) return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i<nums.length; ++i){
            int max = 1;
            for(int j = 0; j<i; ++j){
                if(nums[i] > nums[j]) max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
        }
        int res = 0;
        for(int i = 0; i<dp.length; ++i){
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /* Inprove to O(nlogn) using binary search */
    public int solution(int[] nums){
        if(nums.length < 2) return nums.length;
        /* the dp array stores the smallest tail of an increaing sequnce with length = i-1
        *  Because dp is always an increasing array, we can use binary search on it */
        int[] dp = new int[nums.length];
        int len = 0;
        for(int n : nums){
            /** use java's binary search, which returns -(i + 1) if not found,
             *  with i be the position to insert this value.
             */
            int i = Arrays.binarySearch(dp,0,len,n);
            if(i < 0) i = -(i + 1);
            dp[i] = n;
            if(i == len) len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(input));
    }
}
