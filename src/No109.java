import java.util.ArrayList;
import java.util.List;

public class No109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return constructBST(list, 0, list.size() - 1);
    }

    public TreeNode constructBST(List<Integer> numList, int start, int end) {
        if (start > end) {
            return null;
        }
        int middleIndex = start + (end - start) / 2;
        TreeNode root = new TreeNode(numList.get(middleIndex));
        root.left = constructBST(numList, start, middleIndex - 1);
        root.right = constructBST(numList, middleIndex + 1, end);

        return root;
    }

    public TreeNode sortedListToBSTNoArray(ListNode head) {
        if (head == null) return null;
        return constructBSTNoArray(head, null);
    }

    public TreeNode constructBSTNoArray(ListNode head, ListNode tail) {

        if (head == tail) return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = constructBSTNoArray(head, slow);
        root.right = constructBSTNoArray(slow.next, tail);

        return root;
    }
}
