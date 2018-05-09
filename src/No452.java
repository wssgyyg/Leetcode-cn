import java.util.Arrays;
import java.util.Comparator;

public class No452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1)
            return points.length;
        Arrays.sort(points,
                (point1, point2) -> point1[0] == point2[0] ? (point1[1] - point2[1]) : (point1[0] - point2[0]));

        int count = 1;
        int start = points[0][0], end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][1] <= end) {
                start = points[i][0];
                end = points[i][1];
            } else if (end >= points[i][0]) {
                start = points[i][0];
            } else {
                count++;
                start = points[i][0];
                end = points[i][1];
            }
        }
        return count;
    }
}
