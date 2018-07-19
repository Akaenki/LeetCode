public class Trie {
    private class Node{
        boolean isEnd;
        Node[] child;
        Node(boolean isEnd){
            this.isEnd = isEnd;
            child = new Node[26];
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node top = root;
        for(int i = 0; i<word.length(); ++i){
            char c = word.charAt(i);
            if(top.child[c-'a']==null) {
                top.child[c - 'a'] = new Node(false);
            }
            top = top.child[c-'a'];
        }
        top.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node top = root;
        for(int i = 0; i<word.length(); ++i){
            char c = word.charAt(i);
            System.out.println(c);
            if(top.child[c-'a'] == null) return false;
            top = top.child[c-'a'];
        }
        return top.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node top = root;
        for(int i = 0; i<prefix.length(); ++i){
            char c = prefix.charAt(i);
            if(top.child[c-'a'] == null) return false;
            top = top.child[c-'a'];
        }
        return true;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }
}
