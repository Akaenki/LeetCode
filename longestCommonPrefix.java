/** find the longest prefix of a list of strings */
public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs){
        String prefix = "";
        if(strs.length==0) return prefix;
        int min = Integer.MAX_VALUE;
        for(String s : strs) if(s.length()<min) min = s.length();

        for(int i = 0; i<min; i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(strs[j].charAt(i) != c){
                    return prefix;
                }
            }
            prefix += c;
        }
        return prefix;
    }

    public static void main(String[] args){
        String[] list = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(list));
    }
}
