public class No303 {

}

class NumArray {

    int[] dp;
    public NumArray(int[] nums) {
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j] - dp[i - 1];
    }
}
