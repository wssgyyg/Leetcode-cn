public class No69 {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }

        int left = 1, right = x;
        while (true) {
            int middle = left + (right - left) / 2;
            if (middle * middle > x) {
                right = middle - 1;
            } else if ((middle + 1) * (middle + 1) > x) {
                return middle;
            } else {
                left = middle + 1;
            }
        }
    }
}
