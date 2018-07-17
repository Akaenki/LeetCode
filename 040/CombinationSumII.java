import java.util.*;
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if(i != start && candidates[i] == candidates[i-1]) continue;
                cur.add(candidates[i]);
                combinationSum(candidates,target-candidates[i], i+1, res, cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,5,2,1,2};
        System.out.println(combinationSum2(input, 5).toString());
    }
}
