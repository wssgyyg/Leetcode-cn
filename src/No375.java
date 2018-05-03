public class No375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int right = 2; right <= n; right++) {
            for (int left = right - 1; left >= 0; left--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = left + 1; k < right; k++) {
                    int localMax = k + Math.max(dp[left][k - 1], dp[k + 1][right]);
                    globalMin = Math.min(localMax, globalMin);
                }
                dp[left][right] = (left + 1 == right) ? left : globalMin;
            }
        }
        return dp[1][n];
    }

    int[][] minCostBetween;
    public int getMoneyAmountRecur(int n) {
        minCostBetween = new int[n + 1][n + 1];
        return getMoneyAmountRecur(1, n);
    }

    public int getMoneyAmountRecur(int start, int end) {
        if (start >= end) {
            return 0;
        }

        if (minCostBetween[start][end] != 0) {
            return minCostBetween[start][end];
        }

        int maximum = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            maximum = Math.min(Math.max(getMoneyAmountRecur(start, i - 1), getMoneyAmountRecur(i + 1, end)) + i, maximum);
        }
        minCostBetween[start][end] = maximum;

        return maximum;
    }
}
