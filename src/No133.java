import java.util.HashMap;
import java.util.Map;

public class No133 {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        for (UndirectedGraphNode undirectedGraphNode : node.neighbors) {
            newNode.neighbors.add(cloneGraph(undirectedGraphNode));
        }

        return newNode;
    }
}
