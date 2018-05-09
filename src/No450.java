public class No450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode newRoot = root.right;
            TreeNode par = null;

            while (newRoot.left != null) {
                par = newRoot;
                newRoot = newRoot.left;
            }

            if (par == null) {
                newRoot.left = root.left;
                return newRoot;
            }

            par.left = newRoot.right;
            newRoot.left = root.left;
            newRoot.right = root.right;
            return newRoot;
        }
        return root;
    }
}
