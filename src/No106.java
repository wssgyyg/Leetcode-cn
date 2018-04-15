public class No106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];

        int rootIndex = inStart;
        for (; rootIndex <= inEnd; rootIndex++) {
            if (inorder[rootIndex] == rootVal) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int numNodesLeft = rootIndex - inStart;

        root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + numNodesLeft - 1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postStart + numNodesLeft, postEnd - 1);

        return root;
    }
}
