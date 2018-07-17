public class Random10From7 {
    /** Must be uniform:
     *
     * */
    public static int rand10() {
        while(true){
            int n = 7*(rand7() - 1) + rand7() - 1;
            if(n < 40) return n % 10 + 1;
        }
    }

    public static int rand7(){
        return (int) Math.ceil(Math.random()*7.0);
    }

    public static void main(String[] args) {
        int sum = 0, n = 10000;
        for(int i = 0; i<n; ++i){
            sum += rand10();
        }
        System.out.println(sum*1.0/n);
    }
}
