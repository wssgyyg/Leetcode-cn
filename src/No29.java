public class No29 {

    int result = 0;

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        boolean positive = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0));
        long dividendl = Math.abs((long) dividend);
        long divisorl = Math.abs((long) divisor);


        while (dividendl >= divisorl) {
            int multiple = divideHelper(dividendl, divisorl);
            dividendl -= (divisorl << multiple);
        }

        return positive ? result : -result;

    }

    public int divideHelper(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }

        int shift = 0;
        int multiples = 1;
        while (divisor + divisor < dividend) {
            divisor += divisor;
            multiples <<= 1;
            ++shift;
        }

        result += multiples;

        return shift;
    }

    public static void main(String[] args) {
        System.out.println(new No29().divide(2147483647, 1));
    }
}
