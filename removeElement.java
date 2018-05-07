/** Remove all values equal to val in the array returns the number of value remain
 *  In-place modification of array.
 */
public class removeElement {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        return pos;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int len = removeElement(nums,2);
        for(int i = 0; i<len; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
