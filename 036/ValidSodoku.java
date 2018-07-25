public class ValidSodoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] hash = new int[27][128];
        int n = 9;
        for(int i = 0; i<n; ++i){
            for(int j = 0; j<n; ++j){
                if(board[i][j] == '.') continue;
                char c = board[i][j];
                for(int id : index(i, j)) {
                    if(hash[id][c]++ > 0) return false;
                }
            }
        }
        return true;
    }

    /*    1   2   3
     *    4   5   6
     *    7   8   9     */
    private int[] index(int i, int j){
        int row = i, col = 9 + j;
        int sub = 18 + (i/3 * 3 + j/3);
        return new int[]{row, col, sub};
    }
}
