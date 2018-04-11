import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class No56 {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        result.add(new Interval(start, end));

        return result;
    }
}
