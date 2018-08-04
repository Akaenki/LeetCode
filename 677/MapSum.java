public class MapSum {
    class TrieNode{
        int val = 0;
        TrieNode[] child;
        TrieNode(){
            child = new TrieNode[26];
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode top = root;
        for(char c : key.toCharArray()){
            if(top.child[c-'a'] == null)
                top.child[c-'a'] = new TrieNode();
            top = top.child[c-'a'];
        }
        top.val = val;
    }

    public int sum(String prefix) {
        TrieNode top = root;
        for(char c : prefix.toCharArray()){
            if(top.child[c-'a']==null) return 0;
            top = top.child[c-'a'];
        }
        return sum(top);
    }

    private int sum(TrieNode root){
        if(root == null) return 0;
        int sum = root.val;
        for(int i = 0; i<26; ++i){
            if(root.child[i] != null) sum += sum(root.child[i]);
        }
        return sum;
    }
}
