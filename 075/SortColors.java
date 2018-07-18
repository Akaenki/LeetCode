import java.util.Arrays;

public class SortColors {
    /* Three-way partition problem */
    public static void sortColors(int[] nums) {
        int red = 0, blue = nums.length-1;
        for(int i = 0; i<=blue; i++){
            if(nums[i] == 0) {
                swap(nums, red++, i);
            }else if(nums[i] == 2) {
                swap(nums, blue--, i--);
            }
        }
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j]; a[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,2, 1, 0 , 1, 2, 0 , 1, 1, 1, 0,2,1,1,0, 1, 1, 2, 1};
        sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}
