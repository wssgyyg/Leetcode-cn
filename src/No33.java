public class No33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        int i = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = (left - right) / 2 + right;
            int realMiddle = (middle + i) % nums.length;
            if (nums[realMiddle] > target) {
                right = middle - 1;
            } else if (nums[realMiddle] < target) {
                left = middle + 1;
            } else {
                return realMiddle;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        new No33().search(new int[] { 1, 3 }, 3);
    }
}
