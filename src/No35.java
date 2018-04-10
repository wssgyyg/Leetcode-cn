public class No35 {
    public int searchInsert(int[] nums, int target) {
        int i = firstGreaterOrEqual(nums, target);
        return i;
    }

    public int firstGreaterOrEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
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
