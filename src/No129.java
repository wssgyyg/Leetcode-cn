public class No129 {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int nowSum) {
        if (root == null) return nowSum;

        if (root.left == null && root.right == null) return 10 * nowSum + root.val;

        int result = 0;

        if (root.left != null) {
            result += sumNumbers(root.left, 10 * nowSum + root.val);
        }

        if (root.right != null) {
            result += sumNumbers(root.right, 10 * nowSum + root.val);
        }

        return result;
    }
}
