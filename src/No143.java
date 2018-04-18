public class No143 {
    public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode head2 = split(head);
        head2 = reverseList(head2);
        merge(head, head2);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;

        ListNode start = pre.next;
        ListNode then = start.next;

        while (then != null) {
            start.next = then.next;
            //pay attention to pre.next, cannot be replaced by start as pre never change.
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return pre.next;
    }

    public ListNode split(ListNode head) {
        if (head == null) return null;

        //For slow to stop one before the target we want
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
        ListNode p1 = head1;
        ListNode p2 = head2;

        while (p1 != null && p2 != null) {
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;

            p1.next = p2;
            p2.next = next1;

            p1 = next1;
            p2 = next2;
        }

        return head1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = new No143().reverseList(head);

        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
