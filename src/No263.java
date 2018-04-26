public class No263 {
    public boolean isUgly(int num) {
        for (int i = 2; i < 6; i ++) {
            while (num != 0 && num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
