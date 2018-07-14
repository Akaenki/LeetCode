import java.util.*;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<List<String>> results = new ArrayList<>();
        List<String> init = new ArrayList<>();
        init.add(""); results.add(init);
        for(int i = 1; i<=n; ++i){
            List<String> cur = new ArrayList<>();
            for(int j = 0; j<i; ++j){
                for(String s1 : results.get(j)){
                    for(String s2: results.get(i-j-1)){
                        cur.add("("+s1+")"+s2);
                    }
                }
            }
            results.add(cur);
        }
        return results.get(n);
    }

    private void generateParenthesis(int n, List<String> result){

    }

    public static void main(String[] args) {
        GenerateParenthesis o = new GenerateParenthesis();
        System.out.println(o.generateParenthesis(0).toString());
    }
}
