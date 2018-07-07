import java.util.ArrayList;
import java.util.List;
/** A recursive solution */
public class permutationRec {
    public static List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for(int i : nums) numList.add(i);
        List<Integer> current = new ArrayList<>();
        permute(numList,current);
        return lists;
    }

    private static void permute(List<Integer> numList, List<Integer> cur){
        if(numList.isEmpty()){
            lists.add(cur);
            return;
        }

        for(int i=0; i<numList.size(); i++){
            List<Integer> next = new ArrayList<>(numList);
            List<Integer> current = new ArrayList<>(cur);
            current.add(numList.get(i));
            next.remove(i);
            permute(next,current);
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
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
