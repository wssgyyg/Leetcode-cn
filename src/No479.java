public class No479 {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        long maxNum = (long) Math.pow(10, n) - 1;
        long minNum = (long)Math.pow(10, n - 1);
        long maxProduct = maxNum * maxNum;
        long firstHalf = maxProduct / (long)Math.pow(10, n);

        while (true) {
            long candidate = palindrome(firstHalf--);
            if (candidate > maxProduct) continue;
            for (long i = maxNum; i >= minNum; i--) {
                if (candidate / i > maxNum) break;
                if (candidate % i == 0)
                    return (int)(candidate % 1337);
            }
        }
    }

    public long palindrome(long firstHalf) {
        String str = firstHalf + new StringBuilder().append(firstHalf).reverse().toString();
        return Long.parseLong(str);
    }
}
