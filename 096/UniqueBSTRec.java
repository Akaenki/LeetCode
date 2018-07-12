public class UniqueBSTRec {
    public int numTrees(int n) {
        if(n == 0) return 1;
        if(n < 3) return n;
        int total = 0;
        for(int i = 1; i<=n; ++i){
            total += numTrees(i-1) * numTrees(n-i);
        }
        return total;
    }


    public static void main(String[] args) {
        UniqueBST bst = new UniqueBST();
        System.out.println(bst.numTrees(5));
    }
}
