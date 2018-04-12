public class No61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        int length = 0;
        for (; fast.next != null; length++) {
            fast = fast.next;
        }

        k %= length;

        for (int j = 0; j < (length - k); j++) {
            slow = slow.next;
        }

        fast.next = head;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
