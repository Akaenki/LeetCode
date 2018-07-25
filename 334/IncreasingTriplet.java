public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int low = Integer.MAX_VALUE, high = Integer.MAX_VALUE;
        for(int n : nums){
            if(n <= low) low = n;
            else if(n <= high) high = n;
            else return true;
        }
        return false;
    }
}
