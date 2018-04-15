public class No86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode pointer1 = dummy1;
        ListNode pointer2 = dummy2;
        ListNode pointerOld = head;

        while (pointerOld != null) {
            if (pointerOld.val < x) {
                pointer1.next = pointerOld;
                pointer1 = pointer1.next;
            } else {
                pointer2.next = pointerOld;
                pointer2 = pointer2.next;
            }

            pointerOld = pointerOld.next;
        }


        pointer1.next = dummy2.next;
        pointer2.next = null;

        return dummy1.next;
    }
}
