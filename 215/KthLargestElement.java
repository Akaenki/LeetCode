import java.util.*;

public class KthLargestElement {
    /** Use Max Heap(PQ) the time complexity is O(nlogn + klogn) */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int n : nums) queue.offer(n);
        while(--k > 0) queue.poll();
        return queue.peek();
    }

    /** Divide and Conquer (quick sort) time complexity is O(n) in average */
    public int findKthLargest2(int[] nums, int k) {
        return partition(nums, 0, nums.length-1, nums.length-k+1);
    }

    private int partition(int[] nums, int lo, int hi, int k) {
        int i = lo, j = hi, pivot = nums[hi];
        while (i < j) {
            if (nums[i++] > pivot) swap(nums, --i, --j);
        }
        swap(nums, i, hi);
        int m = i - lo + 1;
        if (m == k) return i;
        else if (m > k) return partition(nums, lo, i - 1, k);
        else return partition(nums, i + 1, hi, k - m);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        KthLargestElement o = new KthLargestElement();
        int[] input = new int[]{3};
        System.out.println(o.findKthLargest2(input, 1));
    }
}
