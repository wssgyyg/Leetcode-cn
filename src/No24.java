public class No24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode next;
        ListNode last;
        while (pre.next != null && pre.next.next != null) {
            next = pre.next;
            last = pre.next.next;

            pre.next = last;
            next.next = last.next;
            last.next = next;

            pre = next;
        }

        return dummy.next;
    }
}
