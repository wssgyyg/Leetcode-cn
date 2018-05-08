import java.util.HashMap;
import java.util.Map;

public class No447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }

            for (int val : map.values()) {
                res += val * (val - 1);
            }
        }
        return res;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = (a[0] - b[0]);
        int dy = (a[1] - b[1]);

        return dx * dx + dy * dy;
    }
}
