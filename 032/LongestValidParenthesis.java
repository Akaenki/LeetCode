import java.util.*;

public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] valid = new int[s.length()];
        for(int i = 0; i<s.length(); ++i){
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            if(s.charAt(i) == ')' && !stack.isEmpty()){
                int idx = stack.pop();
                valid[i] = 1; valid[idx] = 1;
            }
        }
        int max = 0, count = 0;
        for(int i = 0; i<valid.length; ++i){
            if(valid[i] == 1) count++;
            else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()((())()()))()()"));
    }
}
