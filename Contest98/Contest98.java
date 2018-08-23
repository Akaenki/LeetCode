import javafx.util.Pair;

import java.util.*;
public class Contest98 {
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int _val){
            val = _val;
        }
    }
    public static TreeNode buildBST(List<Integer> pre, List<Integer> post){
        if(pre.size() == 0 || post.size() == 0) return null;
        TreeNode root = new TreeNode(pre.get(0));
        if(pre.size() == 1) return root;
        int p1 = pre.size()-1;
        for(int i = 0; i<pre.size(); ++i){
            if(pre.get(i).equals(post.get(post.size()-2))){
                p1 = i; break;
            }
        }
        root.left = buildBST(pre.subList(1, p1), post.subList(0, p1-1));
        root.right = buildBST(pre.subList(p1, pre.size()), post.subList(p1-1, post.size()-1));
        return root;
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int suma = 0, sumb = 0;
        for(int a : A) suma += a;
        for(int b : B) sumb += b;
        for(int i = 0; i<A.length; ++i){
            for(int j = i; j<B.length; ++j){
                if((suma-A[i]+B[j]) == (sumb+A[i]-B[j])) return new int[]{A[i], B[j]};
            }
        }
        return new int[]{-1,-1};
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String word : words){
            if(isPtn(word, pattern)) res.add(word);
        }
        return res;
    }

    private boolean isPtn(String word, String ptn){
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i<word.length(); ++i){
            char c = ptn.charAt(i);
            if(map.containsKey(c) && word.charAt(i) != map.get(c)) return false;
            else if(map.containsValue(c)) return false;
            map.put(c, word.charAt(i));
        }
        return true;
    }


    int MOD = 1000000007;
    public int sumSubseqWidths(int[] A) {
        HashMap<Integer, Long> map = new HashMap<>();
        long res = 0;
        Arrays.sort(A);
        for(int i = 0; i<A.length; ++i){
            if(!map.containsKey(i)) map.put(i, permute(i));
            res += (A[i] * map.get(i));
            if(!map.containsKey(A.length-i-1)) map.put(A.length-i-1, permute(A.length-i-1));
            res -= (A[i] * map.get(A.length-i-1));
            res = Math.floorMod(res, MOD);
        }
        return Math.floorMod(res, MOD);
    }

    private long permute(int n){
        long res = 1;
        for(int i = 0; i<n; ++i) res = res * 2;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(permute(3));
    }
}
