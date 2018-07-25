public class CountAndSay {
    public static String countAndSay(int n) {
        String s = "1";
        while(n-- > 1){
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i<s.length(); ++i){
                if(s.charAt(i) == s.charAt(i-1)) count++;
                else {
                    sb.append(count).append(s.charAt(i-1));
                    count = 1;
                }
            }
            sb.append(count).append(s.charAt(s.length()-1));
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }
}
