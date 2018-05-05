public class No397 {
    public int integerReplacement(int n) {
        if (n == 1)
            return 0;
        else if (n % 2 == 0)
            return 1 + integerReplacement(n / 2);
        else if (Integer.bitCount(n + 1) > Integer.bitCount(n - 1))
            return 1 + integerReplacement(n - 1);
        else
            return 1 + integerReplacement(n + 1);
    }

    public int integerReplacementAV(int n) {
        if (n == 1) return 0;
        if (n == 3) return 2;
        switch (n & 3) {
        case 0:
        case 2:
            return integerReplacement(n / 2) + 1;
        case 1:
            return 1 + integerReplacement(n - 1);
        case 3:
            return 1 + integerReplacement(n + 1);
        }
        return -1;
    }
}
