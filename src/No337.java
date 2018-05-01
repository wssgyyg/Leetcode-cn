import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class No337 {

    public int rob(TreeNode root) {
        if (root == null) return 0;

        int val = root.val;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.right) + rob(root.right.left);
        }

        return Math.max(val, rob(root.left) + rob(root.right));
    }

    public int robWithMap(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    public int rob(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int val = root.val;

        if (root.left != null) {
            val += rob(root.left.left, map) + rob(root.left.right, map);
        }

        if (root.right != null) {
            val += rob(root.right.right, map) + rob(root.right.left, map);
        }

        val = Math.max(val, rob(root.left, map) + rob(root.right, map));
        map.put(root, val);

        return val;
    }

    public int robGreedy(TreeNode root) {
        int[] res = robGreedySub(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robGreedySub(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;

        int[] left = robGreedySub(root.left);
        int[] right = robGreedySub(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
