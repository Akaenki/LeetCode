public class PowerOfFour {
    public static boolean isPowerOfFour(int num) {
        if(num < 4) return false;
        return Integer.bitCount(num) == 1;
    }

    public static void main(String[] args) {
        for(int i = 4; i<100; ++i){
            System.out.println(i + ": " + isPowerOfFour(i));
        }
    }
}
