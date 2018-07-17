public class Search2DMatrix {
    /* Binary Search */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;

        int li = 0, lj = 0, hi = m-1, hj = n-1;
        while(li <= hi){
            int i = (li + hi) / 2;
            if(target > matrix[i][n-1]) li = i + 1;
            else if(target < matrix[i][0]) hi = i - 1;
            else{
                while(lj <= hj) {
                    int j = (lj + hj) / 2;
                    if(target == matrix[i][j]) return true;
                    else if(target > matrix[i][j]) lj = j + 1;
                    else hj = j - 1;
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 7, 9},{12, 14, 16, 18},{30,40,50,60}};
        System.out.println(searchMatrix(matrix, 20));
    }
}
