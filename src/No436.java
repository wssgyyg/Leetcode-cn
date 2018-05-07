import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class No436 {
    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        List<Integer> startList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i].start, i);
            startList.add(intervals[i].start);
        }

        Collections.sort(startList);

        for (int i = 0; i < n; i++) {
            int index = firstGreatOrEqual(intervals[i].end, startList);
            if (index == n) {
                result[i] = -1;
            } else {
                result[i] = map.get(index);
            }
        }
        return result;
    }

    public int firstGreatOrEqual(int target, List<Integer> startList) {
        int left = 0, right = startList.size();
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (startList.get(middle) < target) {
                left = middle + 1;
            }else {
                right = middle;
            }
        }
        return left;
    }

    public int[] findRightIntervalTreeMap(Interval[] intervals) {
        int[] result = new int[intervals.length];
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = entry == null ? -1 : entry.getValue();
        }
        return result;
    }
}
