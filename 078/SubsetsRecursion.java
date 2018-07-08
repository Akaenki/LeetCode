import java.util.List;
import java.util.ArrayList;

public class SubsetsRecursion {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        subsets(nums, 0, list, init);

        return list;
    }

    private static void subsets(int[] nums, int n, List<List<Integer>> list, List<Integer> cur){
        list.add(cur);
        for(int i = n; i<nums.length; i++){
            List<Integer> current = new ArrayList<>(cur);
            current.add(nums[i]);
            subsets(nums, i+1, list, current);
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(subsets(nums).toString());
    }
}
