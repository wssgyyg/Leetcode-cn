import java.util.ArrayList;
import java.util.List;

public class No95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return constructTree(1, n);
    }

    public List<TreeNode> constructTree(int start, int end) {

        List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;

        for (int i = start; i <= end; i++) {
            left = constructTree(start, i - 1);
            right = constructTree(i + 1, end);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }

        return list;

    }
}
