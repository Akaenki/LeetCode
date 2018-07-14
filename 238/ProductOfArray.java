public class ProductOfArray {
    /** O(n) time and space */
    public int[] productExceptSelf(int[] nums) {
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];
        forward[0] = 1;
        for(int i = 1; i<nums.length; ++i){
            forward[i] = forward[i-1] * nums[i-1];
        }
        backward[nums.length-1]=1;
        for(int i = nums.length-2; i>=0; --i){
            backward[i] = backward[i+1] * nums[i+1];
        }
        for(int i = 0; i<nums.length; ++i){
            forward[i] = forward[i] * backward[i];
        }
        return forward;
    }

    /** Reduce space, still O(n) time and space */
    public int[] productExceptSelf2(int[] nums) {
        int[] forward = new int[nums.length];
        forward[0] = 1;
        for(int i = 1; i<nums.length; ++i){
            forward[i] = forward[i-1] * nums[i-1];
        }
        int backward = 1;
        for(int i = nums.length-2; i>=0; --i){
            backward = backward * nums[i+1];
            forward[i] = forward[i] * backward;
        }
        return forward;
    }


    public static void main(String[] args) {
        ProductOfArray poa = new ProductOfArray();
        int[] input = new int[]{1,2,3,4,1,2};
        int[] output = poa.productExceptSelf2(input);
        for(int i = 0; i<output.length; ++i){
            System.out.print(output[i]+" ");
        }
    }
}
