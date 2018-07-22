public class SmallestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int i = 0, j = n - 1;
        while(i < j) {
            int m = (i + j) / 2;
            if(letters[m] <= target)
                i = m + 1;
            else
                j = m;
        }

        if(letters[i] > target)
            return letters[i];

        return letters[0];
    }
}
