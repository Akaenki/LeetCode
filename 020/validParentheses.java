import java.util.Stack;

/** Check parentheses, using Stack */
public class ValidParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<s.length(); i++){
            switch(s.charAt(i)){
                case '(':
                    stack.push(')'); break;
                case '[':
                    stack.push(']'); break;
                case '{':
                    stack.push('}'); break;
                case ')': case ']': case '}':
                    if(stack.isEmpty() || stack.pop()!= s.charAt(i)) return false;
                    break;
            }
            if(stack.size()>s.length()-i-1) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isValid("]"));
    }
}
