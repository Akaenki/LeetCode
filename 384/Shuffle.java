import java.lang.reflect.Array;
import java.util.Arrays;

public class Shuffle {
    private int[] origin;
    public Shuffle(int[] nums) {
        origin = nums;

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(origin, origin.length);
        for(int i = 1; i<shuffled.length; ++i){
            int rand = (int) (Math.random() * (i+1));
            int temp = shuffled[rand];
            shuffled[rand] = shuffled[i];
            shuffled[i] = temp;
        }
        return shuffled;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3};
        Shuffle s = new Shuffle(input);
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
        System.out.println(Arrays.toString(s.shuffle()));
    }
}
