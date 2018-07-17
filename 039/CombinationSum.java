import java.util.*;
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates,target,0,res,new ArrayList<>());
        return res;
    }

    private static void combinationSum(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> cur){
        if(target < 0) return;
        if(target == 0) res.add(new ArrayList<>(cur));
        else{
            for(int i = start; i<candidates.length; ++i){
                /* replace by first add to cur and then remove the last one after recursive call returns
                 * reduce the cost to copy cur into an new array*/
                //List<Integer> next = new ArrayList<>(cur);
                cur.add(candidates[i]);
                combinationSum(candidates,target-candidates[i], i, res, cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        System.out.println(combinationSum(candidates,8).toString());
    }
}
