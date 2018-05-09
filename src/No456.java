import java.util.Stack;

public class No456 {
    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (s3 > num) {
                return true;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                s3 = stack.pop();
            }
            stack.push(num);\
        }

        return false;
    }
}
