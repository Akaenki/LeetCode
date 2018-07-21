public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        if(board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(search(board, i, j, word.toCharArray(), 0)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, char[] word, int cur){
        if(cur >= word.length) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != word[cur])
            return false;
        char temp = board[i][j];
        board[i][j] = '~';
        boolean exist = search(board,i+1, j, word, cur+1) || search(board,i-1, j, word, cur+1)
                || search(board, i, j+1, word, cur+1) || search(board, i, j-1, word, cur+1);
        board[i][j] = temp;
        return exist;
    }

    public static void main(String[] args) {
        String a = "string";
        System.out.println(a.substring(1));
        System.out.println(a);
    }
}
