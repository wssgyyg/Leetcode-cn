import java.util.HashMap;
import java.util.Map;

public class No138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    public RandomListNode copyRandomListII(RandomListNode head) {
        if (head == null) return null;

        if (map.containsKey(head)) {
            return map.get(head);
        }

        RandomListNode node = new RandomListNode(head.label);
        map.put(head, node);
        node.next = copyRandomListII(head.next);
        node.random = copyRandomListII(head.random);

        return node;

    }
}
