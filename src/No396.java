public class No396 {
    public int maxRotateFunction(int[] A) {
        int len = A.length;
        int F = 0;
        int allSum = 0;
        for (int i = 0; i < A.length; i++) {
            allSum += A[i];
            F += i * A[i];
        }

        int max = F;
        for (int i = A.length - 1; i >= 0; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;

    }
}
