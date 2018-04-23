public class No198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int robConstantSpace(int[] nums) {
        int robPrev = 0;
        int notRobPrev = 0;
        for (int  i = 0; i < nums.length; i++) {
            int temp = notRobPrev;
            notRobPrev = Math.max(robPrev, notRobPrev);
            robPrev = nums[i] + temp;
        }

        return Math.max(robPrev, notRobPrev);
    }
}
