public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        int mid;
        while(low < high) {
            mid = (low + high) / 2;
            int c1 = 0, c2 = 0;
            for (int n : nums) {
                if (n <= mid) c1++;
                if (mid == n) c2++;
                if (c2 > 1) return mid;
            }
            if(c1 > mid) high = mid;
            else low = mid + 1;
        }
        return -1;
    }

    /** A genius solution, turns the array into a linked list such that
     *  each element points to the elements with index as it's value */
    public static int solution(int[] nums){
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,1,4,2,1};
        System.out.println(solution(input));
    }
}
