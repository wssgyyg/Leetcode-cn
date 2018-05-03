public class No367 {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long middle = left + (right - right) / 2;
            if (middle * middle == num) {
                return true;
            } else if (middle * middle < num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    public boolean newtonMethod(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }

        return x * x == num;
    }
}
