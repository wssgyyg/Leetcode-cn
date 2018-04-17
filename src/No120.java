import java.util.List;

public class No120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 1, 0);
    }

    public int minimumTotal(List<List<Integer>> triangle, int level, int index) {
        if (level == triangle.size()) {
            return triangle.get(level - 1).get(index);
        }

        return triangle.get(level - 1).get(index) + Math.min(minimumTotal(triangle, level + 1, index), minimumTotal(triangle, level + 1, index + 1));
    }

    public int minimumTotalIter(List<List<Integer>> triangle) {
        int[] mem = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                mem[j] = Math.min(mem[j], mem[j + 1]) + triangle.get(i).get(j);
            }
        }
        return mem[0];
    }
}
