import java.util.HashMap;

public class SubArraySum {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        /** Store all the sum[0..n] have seen and a valid subarray
         *  sum[i..j] = sum[0..j] - sum[0..i-1]
         *          k = cursum    - presum
         */
        for(int i = 0; i<nums.length; ++i){
            sum += nums[i];
            if(map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static int bruteForce(int[] nums, int k){
        int count = 0;
        for(int i = 0; i<nums.length; ++i){
            int sum = 0;
            for(int j = i; j<nums.length; ++j){
                sum+= nums[j];
                if(sum == k) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,1,1};
        System.out.println(bruteForce(input, 2) + " : " + subarraySum(input, 2));
    }
}
