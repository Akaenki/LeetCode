import java.util.Arrays;

public class ReverseString {
    public static String reverseString(String s) {
        int l = 0, h = s.length()-1;
        char[] str = s.toCharArray();
        while(l < h){
            char temp = str[h];
            str[h++] = str[l]; str[l++] = temp;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("w"));
    }
}
