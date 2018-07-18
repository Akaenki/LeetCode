public class MaxAreaContaining {
    /* This fucking problem is asking for the max amout of water (rectangular area)
     * that can be hold by any two barsr */
    public static int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int max = 0;
        while(start < end){
            max = Math.max(max,Math.min(height[start], height[end])*(end - start));
            if(height[start] < height[end]) start++;
            else end--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 10, 9, 4, 4, 4, 4, 4};
        System.out.println(maxArea(input));
    }
}
