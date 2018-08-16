import java.util.*;
public class BasicCalculator {
    public int calculate(String s) {
        char[] str = s.toCharArray();
        Stack<Integer> op = new Stack<>();
        int cur = 0, sign = 1, res = 0;
        for(int i = 0; i<str.length; ++i){
            if(Character.isDigit(str[i])) cur = cur * 10 + Character.getNumericValue(str[i]);
            else {
                res += sign * cur;
                cur = 0;
                if(str[i] == '-') sign = op.isEmpty() ? -1 : -1 * op.peek() ;
                if(str[i] == '+') sign = op.isEmpty() ? 1 : op.peek();
                if(str[i] == '(') op.push(sign);
                if(str[i] == ')') op.pop();
            }
        }
        return Character.isDigit(str[str.length-1]) ? res + sign*cur : res;
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        System.out.println(bc.calculate("1 + 1"));
    }
}
