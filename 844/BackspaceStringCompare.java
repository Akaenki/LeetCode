import java.util.*;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        ArrayList<Character> s = new ArrayList(), t = new ArrayList();
        for (char c : S.toCharArray()) {
            if (c == '#' && s.size() > 0) s.remove(s.size() - 1);
            if(c != '#') s.add(c);
        }
        for (char c : T.toCharArray()) {
            if (c == '#' && t.size() > 0) t.remove(t.size() - 1);
            if(c != '#') t.add(c);
        }

        if (s.size() != t.size()) return false;
        return s.size() == 0 || s.equals(t);
    }
}
