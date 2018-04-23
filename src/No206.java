public class No206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = pre.next;
        ListNode then = start.next;

        while (then != null) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }

    public ListNode reverseListIterBV(ListNode head) {
        ListNode prevHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prevHead;
            prevHead = head;
            head = next;
        }

        return prevHead;
    }

    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return reverseListRec(head, null);
    }

    public ListNode reverseListRec(ListNode head, ListNode newHead) {
        if (head == null) return newHead;

        ListNode next = head.next;
        head.next = newHead;

        return reverseListRec(next, head);
    }
}
