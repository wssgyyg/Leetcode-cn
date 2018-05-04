import java.util.LinkedList;
import java.util.List;

public class No386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            dfs(result, i, n);
        }
        return result;
    }

    public void dfs(List<Integer> result, int target, int limit) {
        if (target > limit) {
            return;
        }
        result.add(target);
        for (int i = 0; i < 10; i++) {
            dfs(result, target * 10 + i, limit);
        }
    }

}
