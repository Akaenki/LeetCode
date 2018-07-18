public class CountPrime {
    public static int countPrimes(int n){
        if(n < 3) return 0;
        int[] a = new int[n+1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (a[i] == 0) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    a[i*j] = 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        for(int i = 0; i<15; ++i) {
            System.out.println(i + ": " + countPrimes(i));
        }
    }
}
