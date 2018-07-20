public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int[] left = new int[heights.length], right = new int[heights.length];
        left[0] = -1; right[heights.length-1] = heights.length;

        for(int i = 1; i< heights.length; ++i){
            int p = i-1;
            while(p >= 0 && heights[p] >= heights[i])
                p = left[p];
            left[i] = p;
        }
        for(int i = heights.length-2; i>=0; --i){
            int p = i+1;
            while(p < heights.length && heights[p] >= heights[i])
                p = right[p];
            right[i] = p;
        }

        int max = 0;
        for(int i = 0; i<heights.length; ++i)
            max = Math.max(max,
                    heights[i] *(right[i] - left[i] - 1 ));
        return max;
    }
}
