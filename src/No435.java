import java.util.Arrays;

public class No435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (x, y) -> (x.end - y.end));
        int count = 1;
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = intervals[i];
            if (interval.start >= end) {
                count++;
                end = interval.end;
            }
        }
        return intervals.length - count;
    }
}
