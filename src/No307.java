public class No307 {

}

class NumArrayII {

    private SegmentTree segmentTree;
    public NumArrayII(int[] nums) {
        segmentTree = new SegmentTree(nums);
    }

    public void update(int i, int val) {
        segmentTree.update(i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.sumRange(i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    int sum;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}

class SegmentTree {
    private SegmentTreeNode root;
    public SegmentTree(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    public SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
        if (start > end) return null;

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = nums[start];
            return root;
        }

        int middle = start + (end - start) / 2;
        root.left = buildSegmentTree(nums, start, middle);
        root.right = buildSegmentTree(nums, middle + 1, end);
        root.sum = root.left.sum + root.right.sum;

        return root;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    public void update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end) {
            root.sum = val;
            return;
        }

        int middle = root.start + (root.end - root.start) / 2;
        if (i <= middle) {
            update(root.left, i, val);
        } else {
            update(root.right, i, val);
        }

        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public int sumRange(SegmentTreeNode root, int i, int j) {
        if (root.end  == j && root.start == i) {
            return root.sum;
        }

        int middle = root.start + (root.end - root.start) / 2;
        if (j <= middle) {
            return sumRange(root.left, i, j);
        } else if (i > middle) {
            return sumRange(root.right, i, j);
        } else {
            return sumRange(root.left, i, middle) + sumRange(root.right, middle + 1, j);
        }
    }
}