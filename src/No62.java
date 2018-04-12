public class No62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePathsByCombination(int m, int n) {
        int total = m + n - 2;
        int down = m - 1;
        double result = 1;

        //so result is total! / ((total-down)! * down!)

        for (int i = 1; i <= down; i++) {
            result = result * (total - down + i) / i;
        }

        return (int) result;
    }
}
