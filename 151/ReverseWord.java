public class ReverseWord {
    public String reverseWords(String s) {
        if(s.length() == 0) return "";
        char[] str = s.toCharArray();
        reverse(str, 0, str.length-1);
        int start = -1, end = -1;
        for(int i = 0; i<=str.length; ++i){
            if(i == str.length || str[i] == ' ' ){
                if(start < end) reverse(str, start+1, end);
                start = i;
            } else{
                end = i;
            }
        }
        if(end == -1) return "";

        /* clean spaces */
        int move = 0;
        for(int k = 0; k<str.length; ++k){
            if(k == 0 && str[k] == ' ') move++;
            else if(k > 0 && str[k] == ' ' && str[k-1] == ' ') move++;
            else str[k-move] = str[k];
        }

        if(str[str.length-1-move]==' ') move++;
        return new String(str).substring(0, str.length-move);
    }

    private void reverse(char[] str, int start, int end){
        while(start < end){
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseWord r = new ReverseWord();
        String input = " ";
        System.out.println(r.reverseWords(input));
        System.out.println(r.reverseWords(input).length());
    }
}
