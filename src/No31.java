public class No31 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int j = nums.length - 1;
                while (j >= i && nums[j] <= nums[i - 1]) --j;
                swap(nums, j, i - 1);
                reverse(nums, i, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }

    public static void main(String[] args) {
        new No31().nextPermutation(new int[]{1, 5, 1});
    }
}
