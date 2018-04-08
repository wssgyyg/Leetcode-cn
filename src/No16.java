import java.util.Arrays;

public class No16 {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int temp = remain - nums[left] - nums[right];
                if (Math.abs(temp) < minDiff) {
                    closestSum = nums[i] + nums[left] + nums[right];
                    minDiff = Math.abs(temp);
                }
                if (temp < 0) {
                    right--;
                } else if (temp > 0) {
                    left++;
                } else {
                    return target;
                }
            }
        }
        return closestSum;
    }
}
