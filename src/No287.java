import java.util.Arrays;

public class No287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left = 0; int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) >> 1;
            if (nums[middle] == nums[middle + 1]) {
                return nums[middle];
            } else if (nums[middle] >= (middle + 1)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }

    public int findDuplicateFloyd(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}
