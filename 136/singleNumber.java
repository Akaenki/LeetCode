/** Sample solution using bitwise XOR:
 *  0 ^ N = N
 *  N ^ N = 0
 */
public class singleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums){
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,3,4,2,1};
        System.out.println(singleNumber(nums));
    }
}
