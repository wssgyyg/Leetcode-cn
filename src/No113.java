import java.util.ArrayList;
import java.util.List;

public class No113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(result, new ArrayList<>(), root, sum);
        return result;
    }

    public void pathSum(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.val == sum && root.left == null && root.right == null) {
            List<Integer> newList = new ArrayList<>(temp);
            newList.add(root.val);
            result.add(newList);
            return;
        }

        temp.add(root.val);
        pathSum(result, temp, root.left, sum - root.val);
        temp.remove(temp.size() - 1);

        temp.add(root.val);
        pathSum(result, temp, root.right, sum - root.val);
        temp.remove(temp.size() - 1);
    }
}
