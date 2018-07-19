import java.util.*;
public class MergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2) return intervals;
        Collections.sort(intervals,(a, b) -> a.start - b.start);

        LinkedList<Interval> res = new LinkedList<>();
        for(Interval i : intervals){
            if(res.isEmpty() || res.getLast().end < i.start) res.add(i);
            else res.getLast().end = Math.max(res.getLast().end, i.end);
        }
        return res;
    }
}
