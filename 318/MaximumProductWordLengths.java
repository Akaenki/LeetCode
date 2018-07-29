public class MaximumProductWordLengths {
    public int maxProduct(String[] words) {
        int[] val = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                val[i] = val[i] | 1 << (c - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((val[i] & val[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }
}
