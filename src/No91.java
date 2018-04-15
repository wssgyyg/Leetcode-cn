public class No91 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                dp[i] = (Integer.valueOf(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        String a = "asdfasdfs";
        System.out.println(a.substring(2));

    }
}
