public class ReverseBits {
    public int reverseBits(int n) {
        if(n == 0) return n;

        int result = 0;
        for(int i = 0; i<32; ++i){
            result <<= 1;
            /** is the last bit is 1, add it to result */
            if((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(43261596));
    }
}
