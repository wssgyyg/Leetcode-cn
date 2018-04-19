public class No148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode head2 = split(head);
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head2);
        return merge(l1, l2);
    }

    public ListNode split(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        if (head1.val < head2.val) {
            head1.next = merge(head1.next, head2);
            return head1;
        }

        head2.next = merge(head1, head2.next);
        return head2;
    }
}
