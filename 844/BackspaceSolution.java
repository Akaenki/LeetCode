public class BackspaceSolution {
    public boolean backspaceCompare(String S, String T) {
        int dels = 0, delt = 0, s = S.length()-1, t = T.length()-1;
        while(s >=0 || t>=0){
            while(s >= 0 && (S.charAt(s) == '#' || dels > 0)){
                if(S.charAt(s--) != '#') dels--;
                else dels++;
            }
            while(t >= 0 && (T.charAt(t) == '#' || delt > 0)){
                if(T.charAt(t--) != '#') delt--;
                else delt++;
            }
            if(s < 0 || t < 0) break;
            if(S.charAt(s) != T.charAt(t)) return false;
            s--; t--;
        }
        return s == t;
    }
}
