public class No114 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);
        flatten(right);

        root.left = null;
        root.right = left;

        TreeNode pointer = root;
        while (pointer.right != null)
            pointer = pointer.right;
        pointer.right = right;
    }
}
