import java.util.Stack;

public class No173 {
}

class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int retVal = stack.peek().val;

        TreeNode right = stack.pop().right;
        pushAllLeft(right);

        return retVal;

    }

    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
