public class No357 {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[n] = (dp[n -1] - dp[n - 2]) * (11 - n) + dp[n - 1];
        }

        return dp[n];
    }
}
