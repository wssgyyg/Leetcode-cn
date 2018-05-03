import java.util.Random;

public class No382 {

}

class Solution {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    int size;
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
        this.size = 0;
        ListNode p = head;
        while (p != null) {
            size++;
            p = p.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int randomIndex = new Random().nextInt(size);
        ListNode p = head;
        while (randomIndex != 0) {
            p = p.next;
            randomIndex--;
        }
        return p.val;
    }
}
