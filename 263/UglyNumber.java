public class UglyNumber {
    public static boolean isUgly(int num) {
        if(num < 1) return false;
        if(num == 1) return true;
        int[] uglys = new int[]{2,3,5};
        for(int u : uglys){
            while(num % u == 0) num = num / u;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        for(int i = 0; i<50; ++i){
            System.out.println(i + ": " + isUgly(i));
        }

    }
}
