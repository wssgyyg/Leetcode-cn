public class No34 {
    public int[] searchRange(int[] nums, int target) {
        int start = searchFirstGreaterEqual(nums, target);
        if (nums[start] != target) {
            return new int[] { -1, -1 };
        }

        int end = searchFirstGreaterEqual(nums, target + 1) - 1;
        return new int[] { start, end };
    }

    public int searchFirstGreaterEqual(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
