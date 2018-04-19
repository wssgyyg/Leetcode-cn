public class No152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int result = nums[0];
        int min = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i],  min * nums[i]);

            result = Math.max(result, max);
        }

        return result;
    }
}
