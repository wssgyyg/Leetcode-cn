public class UnionFind {
    int parents[];

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
        }
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            parents[root2] = root1;
        }

    }

    public int find(int node) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }

        return node;
    }

    public boolean isConnect(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        return root1 == root2;
    }
}