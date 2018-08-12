import java.util.*;
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;

        HashSet<String> visit = new HashSet<>();
        visit.add(beginWord);
        int dist = 1;
        while(!visit.contains(endWord)) {
            HashSet<String> cur = new HashSet<>();
            for (String w : visit) {
                char[] wc = w.toCharArray();
                for (int i = 0; i < wc.length; ++i) {
                    for (char c = 'a'; c <= 'z'; ++c) {
                        wc[i] = c;
                        String next = new String(wc);
                        if (dict.contains(next)) {
                            cur.add(next);
                            dict.remove(next);
                        }
                        wc[i] = w.charAt(i);
                    }
                }
            }
            if (cur.isEmpty()) return 0;
            dist++;
            visit = cur;
        }
        return dist;
    }
}
