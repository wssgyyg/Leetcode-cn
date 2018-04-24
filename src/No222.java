public class No222 {
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 1 ? 0 :
                height(root.right) == h - 1 ? (1 << (h - 1)) + countNodes(root.right)
                                            : ((1 << (h - 2))) + countNodes(root.left);
    }

    private int height(TreeNode root) {
        return root == null ? 0 : 1 + height(root.left);
    }

    public int countNodesIter(TreeNode root) {
        int result = 0;
        int h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                result += 1 << (h - 1);
                root = root.right;
            } else {
                result += 1 << (h - 2);
                root = root.left;
            }
            h--;
        }
        return result;
    }
}
