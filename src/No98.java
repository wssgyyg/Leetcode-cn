public class No98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MAX_VALUE + (long)1, Integer.MIN_VALUE - (long)1);
    }

    public boolean isValidBST(TreeNode root, long maxValue, long minValue) {
        if (root == null) return true;

        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }

        return isValidBST(root.left, root.val, minValue) && isValidBST(root.right, maxValue, root.val);
    }
}
