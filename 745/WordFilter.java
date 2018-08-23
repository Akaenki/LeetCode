public class WordFilter {
    private class TrieNode{
        TrieNode[] children = new TrieNode[27];
        int weight = -1;
        TrieNode(){}
    }

    TrieNode root = new TrieNode();
    public WordFilter(String[] words) {
        for(int i = 0; i<words.length; ++i){
            String word = words[i], suffix = "";
            add(suffix + "{" + word, i);
            for(int j = word.length()-1; j>=0; --j){
                suffix = word.charAt(j) + suffix;
                add(suffix + "{" + word, i);
            }
        }
    }

    private void add(String word, int weight){
        TrieNode top = root;
        for(char c : word.toCharArray()){
            if(top.children[c-'a']==null)
                top.children[c-'a'] = new TrieNode();
            top = top.children[c-'a'];
            top.weight = Math.max(top.weight, weight);
        }
    }

    public int f(String prefix, String suffix) {
        return find(suffix + "{" + prefix);
    }

    private int find(String str){
        TrieNode top = root;
        for(char c : str.toCharArray()){
            if(top.children[c-'a'] == null)
                return -1;
            top = top.children[c-'a'];
        }
        return top.weight;
    }
}
