import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class No399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            graph.computeIfAbsent(equation[0], k -> new HashMap<>()).put(equation[1], values[i]);
            graph.computeIfAbsent(equation[1], k -> new HashMap<>()).put(equation[0], 1 / values[i]);
        }

        double[] r = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            r[i] = dfs(queries[i][0], queries[i][1], 1, graph, new HashSet<>());
        }
        return r;
    }

    public double dfs(String start, String end, double result, Map<String, Map<String, Double>> map, Set<String> seen) {
        if (!map.containsKey(start) || !seen.add(start)) {
            return -1;
        }

        if (start.equals(end)) {
            return result;
        }

        Map<String, Double> adjacencyMap = map.get(start);
        for (String key : adjacencyMap.keySet()) {
            double r = dfs(key, end, result * adjacencyMap.get(key), map, seen);
            if (r != -1) return r;
        }
        return -1;
    }
}
