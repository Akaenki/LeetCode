public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        int n = numRows*2 - 2;
        int[] idx = new int[n];
        for(int i = 0; i<numRows; ++i) idx[i] = i;
        int ptr = numRows;
        for(int i = numRows-2; i>0; --i) idx[ptr++] = i;

        for(int i = 0; i<s.length(); ++i)
            sbs[idx[i%n]].append(s.charAt(i));

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : sbs) res.append(sb);
        return res.toString();
    }
}
