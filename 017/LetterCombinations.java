import java.util.*;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() < 1) return res;
        res.add("");
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc"); map.put(3, "def"); map.put(4, "ghi");
        map.put(5, "jkl"); map.put(6, "mno"); map.put(7, "pqrs");
        map.put(8, "tuv"); map.put(9, "wxyz");

        for(char c : digits.toCharArray()){
            int key = Character.getNumericValue(c);
            String letter = map.get(key);
            List<String> cur = new ArrayList<>();
            for(String a : res) {
                for (char b : letter.toCharArray()) {
                    cur.add(a + b);
                }
            }
            res = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2352").toString());
    }
}
