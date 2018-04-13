public class No81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (right - left) / 2 + left;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        int shift = left;

        for (shift = 0; shift < nums.length; shift++) {
            if (nums[shift] > nums[(shift + 1) % nums.length]) {
                break;
            }
        }

        shift = (shift + 1) % nums.length;

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int middle = (right - left) / 2 + left;
            int realMiddle = (middle + shift) % nums.length;
            if (nums[realMiddle] < target) {
                left = middle + 1;
            } else if (nums[realMiddle] == target) {
                return true;
            } else {
                right = middle - 1;
            }
        }

        return false;

    }
}
