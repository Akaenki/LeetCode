import java.util.Arrays;

public class GameOfLife {
    int m, n;
    public void gameOfLife(int[][] board) {
        m = board.length; n = board[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i<m; ++i)
            for (int j = 0; j < n; ++j)
                res[i][j] = board[i][j];
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j) {
                int count = countLive(res, i, j);
                if(res[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 0;
                }
                if(res[i][j] == 0 && count == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countLive(int[][] board, int i , int j){
        int m = board.length, n = board[0].length;
        int count = 0;
        if(i > 0 && board[i-1][j] == 1) count++;
        if(j > 0 && board[i][j-1] == 1) count++;
        if(i > 0 && j > 0 && board[i-1][j-1] == 1) count++;
        if(i < m-1 && board[i+1][j] == 1) count++;
        if(j < n-1 && board[i][j+1] == 1) count++;
        if(i < m-1 && j < n-1 && board[i+1][j+1] == 1) count++;
        if(i < m-1 && j > 0 && board[i+1][j-1] == 1) count++;
        if(i > 0 && j < n-1 && board[i-1][j+1] == 1) count++;
        return count;
    }
}
