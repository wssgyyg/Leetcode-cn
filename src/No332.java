import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

public class No332 {
    HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            adj.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        visit("JFK");
        return result;
    }

    private void visit(String airport) {
        while (adj.containsKey(airport) && !adj.get(airport).isEmpty()) {
            visit(adj.get(airport).poll());
        }
        result.add(0, airport);
    }
}
