public class No441 {
    public int arrangeCoins(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int middle = (left + right + 1) / 2;
            long sum = (middle + 1) * (long)middle / 2;
            if (sum > n) {
                right = middle - 1;
            } else if (sum <= n) {
                left = middle;
            }
        }
        return left;
    }

    public int arrangeCoinsLinear(int n) {
        int res = 0;
        int rowLen = 1;
        while (n > 0) {
            n -= rowLen;
            rowLen++;
            res++;
        }
        return res == 0 ? res : res - 1;
    }
}
