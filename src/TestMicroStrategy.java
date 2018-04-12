import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TestMicroStrategy {
    public int[] merge(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < nums.length) {
            int target = nums[i];
            if (!stack.isEmpty() && stack.peek() > 0 && target < 0) {
                if (stack.peek() > -target) {
                    i++;
                } else if (stack.peek() == -target) {
                    stack.pop();
                    i++;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(target);
                i++;
            }
        }

        int[] result = new int[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            result[j] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new TestMicroStrategy().merge(new int[] { -1, -2, 1, 2 });
        for (int i = 0;i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
