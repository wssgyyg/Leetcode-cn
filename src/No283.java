import java.util.Arrays;

public class No283 {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[start++] = num;
            }
        }

        Arrays.fill(nums, start, nums.length, 0);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 0, 0, 3 };
        new No283().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
