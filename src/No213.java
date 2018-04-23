public class No213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int low, int high) {
        int notRobPrev = 0;
        int robPrev = 0;

        for (int i = low; i <= high; i++) {
            int temp = notRobPrev;
            notRobPrev = Math.max(robPrev, notRobPrev);
            robPrev = temp + nums[i];
        }

        return Math.max(notRobPrev, robPrev);
    }
}
