import java.util.ArrayList;
import java.util.List;
public class findDisappearedNum {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> miss = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int id = Math.abs(nums[i]) - 1;
            nums[id] = -Math.abs(nums[id]);
        }
        for(int i = 0; i< nums.length; i++)
            if(nums[i]>0) miss.add(i+1);
        return miss;
    }

    public static void main(String[] args){
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> r = findDisappearedNumbers(nums);
        for(int i : r) System.out.print(i+" ");
    }
}
