public class No110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (Math.abs(height(root.left) - height(root.right)) < 2) {
            return isBalanced(root.left) && isBalanced(root.right);
        }

        return false;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
