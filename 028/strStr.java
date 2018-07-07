/** Returns the index of the first occurrence of needle in haystack
 *  Returns -1 if no occurrence is found
 */
public class strStr {
    public static int strStr(String haystack, String needle){
        if(needle.length()==0) return 0;
        if(haystack.length()<needle.length()) return -1;
        for(int i = 0; i<haystack.length()-needle.length()+1; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(compareRest(haystack.substring(i+1,i+needle.length()),
                        needle.substring(1))) return i;
            }
        }
        return -1;
    }

    private static boolean compareRest(String a1, String a2){
        for(int i = 0; i<a1.length(); i++){
            if(a1.charAt(i)!=a2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String a1 = "bilibili";
        String a2 = "bilibilil";
        System.out.println(strStr(a1,a2));
    }
}
