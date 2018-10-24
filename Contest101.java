import java.util.*;
public class Contest101 {
    public int atMostNGivenDigitSet(String[] D, int N) {
        String num = Integer.toString(N);
        int count = 0;
        for(int i = 0; i<num.length()-1; ++i) count += Math.pow(D.length, i+1);

        char[] nums = new char[D.length];
        for(int i = 0; i<nums.length; ++i) nums[i] = D[i].charAt(0);

        count += countlast(nums, 0, num, "");

        return count;
    }

    private int countlast(char[] nums, int index, String N, String cur){
        if(cur.length() == N.length()) return 1;
        int count = 0;
        for(int i = 0; i<nums.length && nums[i] <= N.charAt(cur.length()+1); ++i){
            if(nums[i] == N.charAt(cur.length())+1)
                count += countlast(nums, i, N, cur+nums[index]);
            else
                count += Math.pow(nums.length, N.length()-cur.length());
        }
        return count;

    }

    private static class Pair{
        int id;
        double val;
        Pair(int _id, double _val){
            id = _id; val = _val;
        }
    }

    public static int[] round(double[] prices){
        int down = 0; double sum = 0;
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i<prices.length; ++i) {
            sum += prices[i];
            down += (int) prices[i];
            list.add(new Pair(i, prices[i]));
        }
        int target = (int) Math.round(sum), diff = target - down;
        Collections.sort(list, (a,b)->Double.compare((int)a.val-a.val+1,(int)b.val-b.val+1));
        int[] res = new int[prices.length];
        for(int i = 0; i<list.size(); ++i){
            if(diff > 0){
                int id = list.get(i).id, round = (int)list.get(i).val + 1;
                res[id] = round;
                diff--;
            } else res[list.get(i).id] = (int)list.get(i).val;
        }
        return res;
    }

    public static int flip(int[] nums){
        int count = 0;
        for(int i = 1; i<nums.length-1; ++i){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                if(-nums[i] > nums[i-1] && -nums[i] < nums[i+1]){
                    nums[i] = -nums[i];
                    count++;
                } else return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {

//        double[] test1 = new double[]{1.2, 1.2, 1.2, 1.2};
//        double sum = 0;
//        for(double n : test1) sum += n;
//        System.out.println(Math.round(sum));
//        int[] res = round(test1);
//        for(int n : res) System.out.print(n + " ");



    }
}
