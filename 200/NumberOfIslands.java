import java.util.Arrays;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0, m = grid.length, n = grid[0].length;
        int[][] map = new int[m][n];
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(grid[i][j] == '1'){
                    count++;
                    connected(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void connected(char[][] grid, int i, int j){
        if(grid[i][j] == '0') return;

        grid[i][j] = '0';
        if(i > 0) connected(grid, i - 1, j);
        if(j > 0) connected(grid, i, j - 1);
        if(i < grid.length - 1) connected(grid, i + 1, j);
        if(j < grid[0].length - 1) connected(grid, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{
                "11000".toCharArray(),
                "10000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()};

        System.out.println(numIslands(input));
    }
}
