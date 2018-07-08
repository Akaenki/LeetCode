import java.util.List;
import java.util.ArrayList;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length==0) return list;
        list.add(new ArrayList<>());

        for(int i = 0; i<nums.length; ++i){
            List<List<Integer>> cur = new ArrayList<>(list);
            for(List<Integer> l : list){
                List<Integer> lnew = new ArrayList<>(l);
                lnew.add(nums[i]);
                cur.add(lnew);
            }
            list = cur;
        }
        return list;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums).toString());
    }
}
