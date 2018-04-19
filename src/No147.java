public class No147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode head2 = new ListNode(0);
        ListNode prev = head2;
        ListNode p = head;

        while (p != null) {
            ListNode next = p.next;
            if (prev == null || prev.next == null || prev.next.val > p.val) prev = head2;
            while (prev.next != null && prev.next.val < p.val) {
                prev = prev.next;
            }

            p.next = prev.next;
            prev.next = p;
            p = next;
        }

        return head2.next;
    }
}
