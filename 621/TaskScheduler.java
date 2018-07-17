import java.util.Arrays;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks) freq[c-'A']++;
        Arrays.sort(freq);
        int count = 0, max = freq[25];
        for(int i = 25; i>=0; --i){
            if(freq[i]==max) count++;
            else break;
        }
        return Math.max(tasks.length, (max-1)*(n+1)+count);
    }

    public static void main(String[] args) {
        char[] input = "AAABBB".toCharArray();
        System.out.println(leastInterval(input,2));
    }
}
