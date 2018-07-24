import java.util.*;
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String word : words) set.add(word);

        for(String s : set){
            if(exist(board, s)) res.add(s);
        }
        return res;
    }

    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        if(board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(board[i][j] == word.charAt(0)
                        && search(board, new int[m][n], i, j, word.substring(1))) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, int[][] mark, int i, int j, String world){
        if(world.length() == 0) return true;
        mark[i][j] = 1;
        String next = world.substring(1);
        if(i < board.length-1 && board[i+1][j] == world.charAt(0)
                && mark[i+1][j] != 1 && search(board, mark,i+1, j, next))
            return true;
        if(i > 0 && board[i-1][j] == world.charAt(0)
                && mark[i-1][j] != 1 && search(board, mark,i-1, j, next))
            return true;
        if(j < board[0].length-1 && board[i][j+1] == world.charAt(0)
                && mark[i][j+1] != 1 && search(board, mark, i, j+1, next))
            return true;
        if(j > 0 && board[i][j-1] == world.charAt(0)
                && mark[i][j-1] != 1 && search(board, mark, i, j-1, next))
            return true;
        mark[i][j] = 0;
        return false;
    }
}
