public class No461 {
    public int hammingDistance(int x, int y) {
        x = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((x >>> i) & 1) == 1) {
                res++;
            }
        }
        return res;
    }

    public int hammingDistanceBest(int x, int y) {
        x = x ^ y;
        int res = 0;
        while (x != 0) {
            res++;
            x = x & (x - 1);
        }
        return res;
    }
}
