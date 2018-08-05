public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]] = 'X';
        } else if(board[click[0]][click[1]]=='E'){
            search(board, click);
        }
        return board;
    }

    private int findMine(char[][] board, int[] click){
        int x = click[0], y = click[1];
        int num = 0;
        for(int i = x-1; i<=x+1; ++i){
            for(int j = y-1; j<=y+1; ++j){
                if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) continue;
                if(i == x && j == y) continue;
                if(board[i][j]=='M') num++;
            }
        }
        return num;
    }

    private void search(char[][] board, int[] click){
        int x = click[0], y = click[1];
        int num = findMine(board, click);
        if(num != 0){
            board[x][y] = (char)(num+'0');
            return;
        }
        board[x][y] = 'B';
        for(int i = x-1; i<=x+1; ++i){
            for(int j = y-1; j<=y+1; ++j){
                if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) continue;
                if(i == x && j == y) continue;
                if(board[i][j] != 'E') continue;
                search(board, new int[]{i, j});
            }
        }
    }
}
