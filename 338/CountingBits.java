public class CountingBits {
    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        for(int i = 1; i<=num; ++i){
            result[i] = result[i/2] + i % 2;
        }
        return result;
    }

    /* DEBUG ONLY */
    public static int[] trivial(int num){
        int[] result = new int[num+1];
        result[0] = 0;
        for(int i = 1; i<=num; ++i)
            result[i] = count(i);
        return result;
    }

    public static int count(int num){
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = countBits(64);
        for(int i = 0; i<a.length; ++i){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int[] b = trivial(64);
        for(int i = 0; i<b.length; ++i){
            System.out.print(b[i] + " ");
        }
    }
}
