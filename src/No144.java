import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //preorderTraversalRecursive(root, result);
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return result;
    }

    public void preorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorderTraversalRecursive(root.left, result);
        preorderTraversalRecursive(root.right, result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            result.add(node.val);
            root = node.right;
        }

        return result;
    }
}
