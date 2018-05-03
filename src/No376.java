public class No376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int n = nums.length;
        int upBefore = 1;
        int downBefore = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                upBefore = downBefore + 1;
            } else if (nums[i] < nums[i - 1]) {
                downBefore = upBefore + 1;
            }
        }

        return Math.max(upBefore, downBefore);
    }
}
