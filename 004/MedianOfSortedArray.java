public class MedianOfSortedArray {
    /** Separate the each of the two array into two parts
     *  A[0] .... A[i-1] | A[i] .... A[a]
     *  B[0] .... B[j-1] | B[j] .... A[b]
     *  so that:
     *  the total # of element in the left part equals to the right part (or -1)
     *  satisfy that A[i-1] < B[j] && B[j-1] < A[i]
     *  Ensure that a > b then i = {0, m} and j = (a+b+1)/2-i and search for i.
     *  Once the i is found if (a + b) is odd, the median is the max of A[i-1] and B[j-1]
     *  if (a + b) is even, the median is the average of max(A[i-1],B[j-1]) and min(A[i], B[j])
     *
     *  Use binary search then the run time is O(loga)
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length, b = nums2.length;
        if(a > b) return findMedianSortedArrays(nums2, nums1);

        /** Binary Search for i */
        int low = 0, high = a;
        while(low <= high){
            int i = (low + high)/2;
            int j = (a + b + 1)/2 - i;
            if(i < a && nums1[i] < nums2[j-1]) low = i + 1;
            else if(i > 0 && nums1[i-1] > nums2[j]) high = i - 1;
            else{
                int left, right;
                if(i < 1) left = nums2[j-1];
                else if(j < 1) left = nums1[i-1];
                else left = Math.max(nums1[i-1], nums2[j-1]);

                if((a + b) %  2 == 1) return left;

                if(i >= a) right = nums2[j];
                else if(j >= b) right = nums1[i];
                else right = Math.min(nums1[i], nums2[j]);

                return (left + right) / 2.0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
