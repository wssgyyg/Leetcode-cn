public class No162 {
    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }

        return nums.length - 1;
    }

    public int findPeakElementBS(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle1 = left + (right - left) / 2;
            int middle2 = middle1 + 1;
            if (nums[middle1] < nums[middle2]) {
                left = middle2;
            } else {
                right = middle1;
            }
        }

        return left;
    }
}
