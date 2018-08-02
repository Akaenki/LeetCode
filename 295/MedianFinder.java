import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    /** min-heap - upper half, max-heap - lower half */
    PriorityQueue<Integer> min, max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b)->b-a);
    }

    public void addNum(int num) {
        min.offer(num);
        max.offer(min.poll());
        if(min.size() < max.size()){
            min.offer(max.poll());
        }
    }

    public double findMedian() {
        if(min.size() == max.size()) return (min.peek() + max.peek())/2.0;
        return 1.0*min.peek();
    }
}
