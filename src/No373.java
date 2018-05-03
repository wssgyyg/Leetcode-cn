import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class No373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<int[]> res = new LinkedList<>();
            if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
            for (int i = 0; i < nums1.length && i < k; i++) minHeap.offer(new int[] {nums1[i], nums2[0], 0});
            while (k-- > 0 && !minHeap.isEmpty()) {
                int[] curr = minHeap.poll();
                res.add(new int[] { curr[0], curr[1] });
                if (curr[2] == nums2.length - 1) continue;
                minHeap.offer(new int[] { curr[0], nums2[curr[2] + 1], curr[2] + 1 });
        }
        return res;
    }
}
