public class No374 {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (guess(middle) == 0) {
                return middle;
            } else if (guess(middle) < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public int guess(int n) {
        return 0;
    }
}
