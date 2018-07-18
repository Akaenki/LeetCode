import java.util.*;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<String> c = new Stack<>();
        Stack<Integer> n = new Stack<>();
        String digit = "", res = "";
        for(int i = 0; i<s.length(); ++i){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                digit += cur;
                if(!Character.isDigit(s.charAt(i+1))) {
                    n.push(Integer.parseInt(digit));
                    digit = "";
                }
            } else if(cur == '['){
                c.push(res); res = "";
            } else if(cur == ']'){
                int num = n.pop();
                String temp = c.pop();
                while(num-- > 0) temp = temp + res;
                res = temp;
            } else res += cur;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "3[a]2[b4[F]c]";
        System.out.println(decodeString(s));
    }
}
