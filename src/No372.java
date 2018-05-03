public class No372 {
    private int base = 1337;
    public int superPow(int a, int[] b) {
        return superPow(a, b, 0, b.length - 1);
    }

    public int superPow(int a, int[] b, int start, int end) {
        if (start > end) return 1;
        int lastDigit = b[end];
        return powmod(superPow(a, b, start, end - 1), 10) * powmod(a, lastDigit) % base;
    }

    private int powmod(int a, int k) {
        a %= k;
        int result = 1;
        for (int i = 0; i < k; i++) {
            result = result * a % base;
        }
        return result;
    }
}
