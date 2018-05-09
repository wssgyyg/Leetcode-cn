import java.util.HashMap;

public class No454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int num1 : C) {
            for (int num2 : D) {
                int sum = num1 + num2;
                res += map.getOrDefault(-sum, 0);
            }
        }

        return res;
    }
}
