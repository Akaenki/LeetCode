import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderedPower {
    /** This messy code was written in a contest :P */
    public static boolean reorderedPowerOf2(int N) {
        if(N == 1) return true;
        List<Integer> d = new ArrayList<>();
        int n = N;
        while(n > 0){
            d.add(n % 10); n = n/10;
        }
        int[] digits = new int[d.size()];
        int k = 0;
        for(int a : d){
            digits[k++] = a;
        }

        Arrays.sort(digits);
        int end = digits[digits.length-1], start = digits[0];
        k = 0;
        while(start == 0){
            start = digits[++k];

        }

        int power = 2;
        List<List<Integer>> all = new ArrayList<>();
        while(power < (end + 1) * Math.pow(10, d.size()-1)){
            if(power > start * Math.pow(10, d.size()-1)){
                List<Integer> dp = new ArrayList<>();
                int p = power;
                while(p > 0){
                    dp.add(p % 10); p = p/10;
                }
                all.add(dp);
            }
            power *= 2;
        }

        for(int i = 0; i<all.size(); ++i){
            List<Integer> cur = all.get(i);
            for(int j = 0; j<d.size(); ++j){
                if(cur.contains(d.get(j))){
                    cur.remove(d.get(j));
                }
            }
            if(cur.isEmpty()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(46));
    }
}
