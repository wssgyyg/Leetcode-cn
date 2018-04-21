import java.util.Arrays;

public class No167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (temp == target) {
                return new int[] {left + 1, right + 1};
            } else if (temp < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }
}
