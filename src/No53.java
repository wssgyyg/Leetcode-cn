public class No53 {
    public int maxSubArray(int[] nums) {
        int tempSum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (tempSum < 0) {
                tempSum = nums[i];
            } else {
                tempSum += nums[i];
            }
            max = Math.max(max, tempSum);
        }

        return max;
    }

    public int dpMaxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + dp[i - 1] > 0 ? dp[i - 1] : 0;
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
