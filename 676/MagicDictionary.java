public class MagicDictionary {
    private class Trie{
        boolean end;
        Trie[] next;
        Trie(){ next = new Trie[26];}
    }

    private Trie root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word : dict){
            Trie top = root;
            for(char w : word.toCharArray()){
                if(top.next[w-'a'] == null)
                    top.next[w-'a'] = new Trie();
                top = top.next[w-'a'];
            }
            top.end = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return search(root, word, 0, new int[]{0});
    }

    private boolean search(Trie root, String word, int ptr, int[] diff){
        if(diff[0] > 1) return false;
        if(ptr == word.length() && root.end && diff[0] == 1) return true;
        else if(ptr == word.length()) return false;
        for(int i = 0; i<26; ++i){
            if(root.next[i] != null
                    && search(root.next[i],word,ptr+1,
                    (word.charAt(ptr)-'a')==i?new int[]{diff[0]} : new int[]{diff[0]+1}))
            return true;
        }
        return false;
    }
}
