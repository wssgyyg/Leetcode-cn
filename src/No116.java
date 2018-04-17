public class No116 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;

        while (root != null) {
            TreeLinkNode p = root;
            while (p != null && p.left != null) {
                p.left.next = p.right;
                p.right.next = p.next == null ? null : p.next.left;
                p = p.next;
            }

            root = root.left;
        }
    }
}
