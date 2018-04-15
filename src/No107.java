import java.util.LinkedList;
import java.util.List;

public class No107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result, root, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) return;
        if (result.size() == level) {
            result.add(0, new LinkedList<>());
        }

        result.get(result.size() - level - 1).add(root.val);
        helper(result, root.left, level + 1);
        helper(result, root.right, level + 1);
    }
}
