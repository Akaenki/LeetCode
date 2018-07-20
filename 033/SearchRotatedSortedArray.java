public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int l = 0;
        for(int i = 1; i<nums.length; ++i){
            if(nums[i] < nums[i-1]) {
                l = i; break;
            }
        }
        int h = l == 0 ? nums.length - 1 : l - 1;

        while(nums[l] < nums[h]) {
            if(target > nums[h] || target < nums[l]) return -1;
            int mid = l < h ? (l + h) / 2 : ((l + h + nums.length)/2) % nums.length;
            //System.out.print(mid + " ");
            if(target == nums[mid]) return mid;
            else if (target < nums[mid]) h = Math.floorMod(mid - 1, nums.length);
            else l = Math.floorMod(mid + 1, nums.length);
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        System.out.println(Math.floorMod(-1, 2));
    }
}
