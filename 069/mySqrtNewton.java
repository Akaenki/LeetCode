/** Compute the integer part of a square root
 *  Implementation using Newton's method
 */
public class mySqrtNewton {
    public static int mySqrt(int x){
        if(x==0 || x==1) return x;
        int root = x/2;
        while(root > x/root){
            root = (root + x/root)/2;
        }
        return root;
    }

    public static void main(String[] args){
        System.out.println(mySqrt(25));
    }
}
