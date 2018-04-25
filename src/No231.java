public class No231 {
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            if (1 << i == n) {
                return true;
            }
        }

        return false;
    }

    public boolean isPowerOfTwoBV(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0 ? true : false;
    }
}
