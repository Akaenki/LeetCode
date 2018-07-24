public class PeakElement {
    /** If num[i-1] < num[i] > num[i+1], then num[i] is peak
        If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
        If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
        If num[i-1] > num[i] < num[i+1], then both sides have peak */
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length-1);
    }

    public int findPeak(int[] nums,int start,int end){
        if(start == end) return start;
        if(start+1 == end){
            if(nums[start] > nums[end]) return start;
            else return end;
        } else{
            int m = (start + end) / 2;
            if(nums[m] > nums[m-1] && nums[m] > nums[m+1])
                return m;
            else if(nums[m-1] > nums[m] && nums[m] > nums[m+1])
                return findPeak(nums,start,m-1);
            else
                return findPeak(nums,m+1,end);
        }
    }
}
