public class ValidAnagram {
    /** Only support ASCII. To include unicode easiest way is to sort each string
     *  and then compare
     */
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 0) return true;
        int[] hash = new int[256];

        for(int i = 0; i<s.length(); ++i){
            hash[s.charAt(i)] += 1;
        }

        for(int i = 0; i<t.length(); ++i){
            hash[t.charAt(i)] -= 1;
            if(hash[t.charAt(i)] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
