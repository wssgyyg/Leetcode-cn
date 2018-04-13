public class No82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;

        while (p != null) {
            while (p.next != null && p.val == p.next.val) {
                p = p.next;
            }

            if (pre.next == p) {
                pre = pre.next;
            } else {
                pre.next = p.next;
            }
            p = p.next;
        }

        return dummy.next;

    }
}
