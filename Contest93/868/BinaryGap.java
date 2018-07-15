import java.beans.BeanInfo;
import java.util.*;

public class BinaryGap {
    public int binaryGap(int N) {
        int max = 0;
        String s = Integer.toBinaryString(N);
        int start = -1, count = 0;
        for(int i = 0; i<s.length(); ++i){
            if(s.charAt(i) == '1'){
                max = Math.max(max, count);
                start = 0; count = 1;
            }

            if(start != -1 && s.charAt(i) == '0') count++;
        }
        return max;
    }

    public static void main(String[] args) {
        BinaryGap o = new BinaryGap();
        System.out.println(o.binaryGap(8));
    }
}
