public class SumTwoIntegers {
    /* Sum in binary ex: 1 + 2 = 01 + 10 = 11
     * For case like 10 + 10 = 100:
     * c = a & b = 10, c << 1 = 100, a ^ b = 0
     * Final result: 100 ^ 0 = 100, iterate until a & b = 0;
     */
    public int getSum(int a, int b) {
        while(b != 0){
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(6));
    }
}
