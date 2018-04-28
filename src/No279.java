import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class No279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for(int j = 1; (i - j * j) >= 0; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];

    }

    public int numSquaresBFS(int n) {
        int depth = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int node = queue.poll();
                for (int i = 1; (node + i * i) <= n; i++) {
                    int val = node + i * i;
                    if (val == n) {
                        return depth;
                    }
                    if (val > n) {
                        break;
                    }
                    if (visited.add(val)) {
                        queue.offer(val);
                    }
                }
            }

        }

        return depth;
    }
}
