import java.util.PriorityQueue;

public class No378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>();
        for (int i = 0; i< matrix.length && i < k; i++) minHeap.offer(new Tuple(matrix[i][0], i, 0));
        for (; k > 1; k--) {
            Tuple tuple = minHeap.poll();
            if (tuple.y == matrix[0].length - 1) continue;
            minHeap.offer(new Tuple(matrix[tuple.x][tuple.y + 1], tuple.x, tuple.y + 1));
        }

        return minHeap.poll().value;
    }

    class Tuple implements Comparable<Tuple>{
        Integer value;
        Integer x;
        Integer y;

        Tuple(Integer value, Integer x, Integer y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Tuple tuple) {
            return value.compareTo(tuple.value);
        }
    }

    public int kthSmallestBS(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1];
        while (low < high) {
            int middle = low + (high - low) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > middle);
            }
        }
        return 0;
    }

}
