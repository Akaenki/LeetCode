import java.util.Arrays;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(matrix[i][j] == '0')
                    heights[j] = 0;
                else heights[j]++;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

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
