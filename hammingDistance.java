/** A stupid solution */
public class hammingDistance {
    public static int hammingDistance(int x, int y) {
        int count = 0;
        while(x!=0 || y!=0){
            if(x % 2 != y % 2) count++;
            x = x/2; y = y/2;
        }
        return count;
        //return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args){
        System.out.println(hammingDistance(1,6));
    }
}
