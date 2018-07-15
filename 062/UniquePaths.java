public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        if(Math.min(m, n) == 1) return 1;
        if(Math.min(m, n) == 2) return Math.max(m, n);
        if(m < n) return uniquePaths(n, m);
        m--; n--;
        /* Permutation = (m + n)!/(m!n!) */
        long perm = 1;
        for(int i = m+1, j = 1; i<=m+n; ++i, ++j){
            perm *= i; perm /= j;
        }
        return (int) perm;
    }



    public static void main(String[] args) {
        System.out.println(uniquePaths(14,2));
    }
}
