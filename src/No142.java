public class No142 {
    public ListNode detectCycle(ListNode head) {
        ListNode runner = head;
        ListNode walker = head;
        boolean existsCycle = false;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;

            if (runner == walker) {
                existsCycle = true;
                break;
            }
        }

        if (!existsCycle)
            return null;

        walker = head;
        while (walker != runner) {
            walker = walker.next;
            runner = runner.next;
        }

        return walker;
    }
}
