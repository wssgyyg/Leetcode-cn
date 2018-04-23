public class No204 {
    public int countPrimes(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = isPrime(i - 1) ? (1 + dp[i - 1]) : dp[i - 1];
        }
        return dp[n];
    }

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return true;
            }
        }

        return false;
    }
}
