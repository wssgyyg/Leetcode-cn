public class No235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int smaller = Math.min(p.val, q.val);
        int bigger = Math.max(p.val, q.val);

        if (smaller == root.val || bigger == root.val) return root;
        if (smaller < root.val && root.val < bigger) {
            return root;
        } else if (root.val > bigger) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
