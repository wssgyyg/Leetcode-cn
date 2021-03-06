public class No365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;

        if (x == z || y == z || (x + y) == x) {
            return true;
        }
        return z % GCD(x, y) == 0;
    }

    public int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = b;
        }
        return a;
    }
}
