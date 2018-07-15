public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n/2; ++i){
            for(int j = i; j<n-i-1; ++j){
                int count = 3;
                int[] cur = new int[]{i, j};
                while(count-- > 0) {
                    int[] next = next(cur, n-1);
                    swap(matrix, cur, next);
                    cur = next;
                }
            }
        }
    }

    private int[] next(int[] cur, int n){
        int[] next = new int[2];
        next[0] = n - cur[1];
        next[1] = cur[0];
        return next;
    }

    private void swap(int[][] matrix, int[] cur, int[] next){
        int temp = matrix[cur[0]][cur[1]];
        matrix[cur[0]][cur[1]] = matrix[next[0]][next[1]];
        matrix[next[0]][next[1]] = temp;
    }

    public static void main(String[] args) {

    }

}
