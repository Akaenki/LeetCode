/** Return number of unique integers in a sorted array in-place modification of array
 *  No ADT is used
 */
public class removeDup {
    public static int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int pos = 1;
        for(int i = 1; i<nums.length; i++){
            int cur = nums[i];
            if(cur != prev){
                nums[pos] = nums[i];
                pos += 1;
            }
            prev = cur;
        }
        return pos;
    }

    public static void main(String[] args){
        int[] num = new int[]{1,1,2,2,3,4,5,5,7,8};
        int len = removeDuplicates(num);
        for(int i = 0; i<len; i++){
            System.out.println(num[i]);
        }
    }
}
