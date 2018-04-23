import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;

    }

    public List<Integer> rightSideViewRecur(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        rightSideViewRecur(root, result, 0);
        return result;
    }

    public void rightSideViewRecur(TreeNode root, List<Integer> result, int height) {
        if (root == null) return;

        if (height == result.size()) {
            result.add(root.val);
        }

        rightSideViewRecur(root.right, result, height + 1);
        rightSideViewRecur(root.left, result, height + 1);
    }
}
