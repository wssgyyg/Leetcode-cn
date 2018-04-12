public class No70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairsWithNoExtraSpace(int n) {
        int first = 0;
        int second = 1;
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}
