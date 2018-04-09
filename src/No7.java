public class No7 {
    public int reverse(int x) {
        int origin = x;
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }

        if (origin < 0 && result > 0){
            return 0;
        }
        return result;
    }
}
