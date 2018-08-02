import java.util.*;

public class LargestNum {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i = 0; i<nums.length; ++i) str[i] = ""+nums[i];

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return -str1.compareTo(str2);
            }
        });

        StringBuilder res = new StringBuilder();
        for(String s : str) res.append(s);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("128".compareTo("12"));
    }
}
