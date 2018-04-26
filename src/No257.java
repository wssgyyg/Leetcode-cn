import java.util.ArrayList;
import java.util.List;

public class No257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(result, "", root);
        return result;
    }

    public void binaryTreePaths(List<String> result, String temp, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result.add(new String(temp.substring(0, temp.length() - 1)));
            return;
        }

        temp = temp + root.val + "->";
        binaryTreePaths(result, temp, root.left);
        binaryTreePaths(result, temp, root.right);
    }
}
