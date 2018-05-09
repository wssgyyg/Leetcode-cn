import java.util.stream.IntStream;

public class No453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }

        return sum - nums.length * min;
    }
}
