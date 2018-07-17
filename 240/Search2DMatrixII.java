public class Search2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;

        int i = 0, j = n-1;
        while(i<m && j>=0){
            if(target == matrix[i][j]) return true;
            else if(target < matrix[i][j]) j--;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{}};
        System.out.println(searchMatrix(input, 11));
    }
}
