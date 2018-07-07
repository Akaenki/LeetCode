import java.util.ArrayList;
import java.util.List;
/** An iterative solution (faster) */
public class permutationItr {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length==0) return list;
        List<Integer> init = new ArrayList<>();
        init.add(nums[0]);
        list.add(init);

        for(int i = 1; i<nums.length; i++){
            List<List<Integer>> current = new ArrayList<>();
            for(List<Integer> l : list){
                for(int j = 0; j<=i; j++){
                    List<Integer> lnew = new ArrayList<>(l);
                    lnew.add(j,nums[i]);
                    current.add(lnew);
                }
            }
            list = current;
        }
        return list;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> result = permute(nums);

        for(int i = 0;i<result.size();i++){
            System.out.print("[ ");
            List<Integer> e = result.get(i);
            for(int j = 0;j<e.size();j++){
                System.out.print(e.get(j)+" ");
            }
            System.out.println("]");
        }
    }
}
