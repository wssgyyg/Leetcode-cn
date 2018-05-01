public class No343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = i - 1; j >= 2; j--) {
                dp[i] = Math.max(Math.max(dp[j], j) * Math.max(dp[i - j], i - j), dp[i]);
            }
        }
        return dp[n];
    }
}
