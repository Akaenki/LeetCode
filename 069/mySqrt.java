/** Returns the integer part of the square root
 *  Implementation using binary search
 * */
public class mySqrt {
    public static int mySqrt(int x){
        if(x==0 || x==1) return x;
        int min = 0; int max = x;
        while(min < max-1){
            int mid = (max+min)/2;
            if(mid <= x/mid) min = mid;
            else max = mid;
        }
        return min;
    }

    public static void main(String[] args){
        System.out.println(mySqrt(40));
    }
}
