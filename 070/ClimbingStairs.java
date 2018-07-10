public class ClimbingStairs {
    /* Fibonacci*/
    public static int climbStairs(int n){
        if(n < 4) return n;
        int a = 2, b = 3;
        for(int i = 3; i<n; i++){
            b += a;
            a = b - a;
        }
        return b;
    }

    public static int solution(int n){
        if(n < 4) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args){
        int n = 45;
        System.out.println(climbStairs(n) + " " + solution(n));
    }
}
