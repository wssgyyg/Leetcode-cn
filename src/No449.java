import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No449 {
    public class Codec {
        private final static String SPLIT = ",";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            sb.append(root.val + SPLIT);
            sb.append(serialize(root.left));
            sb.append(serialize(root.right));

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) return null;
            Queue<String> queue = new LinkedList<>();
            queue.addAll(Arrays.asList(data.split(SPLIT)));
            return deserialize(queue);
        }

        public TreeNode deserialize(Queue<String> queue) {
            if (queue.size() == 0) return null;
            String cur = queue.poll();
            Queue<String> smallerQueue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.valueOf(cur));
            while (!queue.isEmpty() && Integer.valueOf(queue.peek()) < root.val) {
                smallerQueue.offer(queue.poll());
            }
            root.left = deserialize(smallerQueue);
            root.right = deserialize(queue);

            return root;
        }
    }
}
