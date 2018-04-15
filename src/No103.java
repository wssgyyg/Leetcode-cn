import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        zigzagLevelOrder(result, root, 0);
        return result;
    }

    public void zigzagLevelOrder(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) return;

        if (result.size() == level) {
            result.add(new LinkedList<>());
        }

        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            result.get(level).add(0, root.val);
        }

        zigzagLevelOrder(result, root.left, level + 1);
        zigzagLevelOrder(result, root.right, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrderIter(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderd = true;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if (isOrderd) {
                    subList.add(node.val);
                } else {
                    subList.add(0, node.val);
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(subList);
            isOrderd = !isOrderd;
        }
        return result;
    }
}
