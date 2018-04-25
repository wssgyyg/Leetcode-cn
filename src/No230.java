import java.util.Stack;

public class No230 {
    public int kthSmallest(TreeNode root, int k) {
        while (root != null) {
            int leftNodeNum = nodeNum(root.left);
            if (k == (leftNodeNum + 1)) {
                return root.val;
            } else if (k < (leftNodeNum + 1)) {
                root = root.left;
            } else {
                k = k - leftNodeNum - 1;
                root = root.right;
            }
        }

        return -1;
    }

    public int nodeNum(TreeNode root) {
        if (root == null) return 0;
        return 1 + nodeNum(root.left) + nodeNum(root.right);
    }


    int count;
    int num;
    public int kthSmallestRecr(TreeNode root, int k) {
        count = k;
        kthSmallestRecr(root);
        return num;
    }

    public void kthSmallestRecr(TreeNode root) {
        if (root.left != null) kthSmallestRecr(root.left);
        count--;
        if (count == 0) {
            num = root.val;
            return;
        }
        if (root.right != null) kthSmallestRecr(root.right);
    }

    public int kthSmallestIter(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            root = node.right;
        }

        return -1;
    }
}
