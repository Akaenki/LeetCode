import java.util.*;
public class Contest96 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int bot = 0;
        int[] row = new int[n], col = new int[n];
        for(int i = 0; i<n; ++i){
            for(int j = 0; j<n; ++j){
                if(grid[i][j] > 0) bot++;
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int sum = bot;
        for(int r : row) sum+= r;
        for(int c : col) sum+= c;
        return sum;
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int l = 0, h = people.length;
        while(l < h){
            if(people[l] + people[h] > limit) {
                count++;
                h--;
            } else {
                count++;
                h--; l++;
            }
        }
        return l==h ? count+1:count;
    }

    public String decodeAtIndex(String S, int k) {
        char[] str = S.toCharArray();
        int ptr = 0, prev = 0;
        while(k > 0){
            char c = str[ptr];
            if(Character.isDigit(c)){
                int count = Character.getNumericValue(c);
                while(count-- > 1){
                    if(k - prev > 0) k-=prev;
                    else return decodeAtIndex(S, k);
                }
                prev = count*prev;
            } else {
                prev++; k--;
            }
            ptr++;
        }
        if(Character.isLetter(str[ptr-1])) return str[ptr-1]+"";
        else return str[0]+"";
    }
}
