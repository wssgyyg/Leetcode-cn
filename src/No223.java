public class No223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int down = Math.max(B, F);

        int overlap = 0;
        if (right > left && top > down) {
            overlap = (right - left) * (top - down);
        }

        return areaA + areaB - overlap;
    }

}
