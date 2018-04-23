import java.util.HashSet;
import java.util.Set;

public class No200 {
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        UnionFind unionFind = new UnionFind(rows * cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1')
                        unionFind.union(node(i, j), node(i - 1, j));
                    if (i < rows - 1 && grid[i + 1][j] == '1')
                        unionFind.union(node(i, j), node(i + 1, j));
                    if (j > 0 && grid[i][j - 1] == '1')
                        unionFind.union(node(i, j), node(i, j - 1));
                    if (j < cols - 1 && grid[i][j + 1] == '1')
                        unionFind.union(node(i, j), node(i, j + 1));
                } else {
                    unionFind.count--;
                }
            }
        }

        return unionFind.count;

    }

    public int numIslandsRecur(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    DFSMarker(grid, i, j);
                }
            }
        }

        return count;

    }

    public void DFSMarker(char[][] grid, int i, int j) {
        if (i < grid.length && i >= 0 && j < grid[0].length && j >= 0 && grid[i][j] == '1') {
            grid[i][j] = '0';
            DFSMarker(grid, i - 1, j);
            DFSMarker(grid, i + 1, j);
            DFSMarker(grid, i, j - 1);
            DFSMarker(grid, i, j + 1);
        }
    }

    private int node(int i, int j) {
        return i * cols + j;
    }

    class UnionFind {
        int[] parents;
        int count;

        UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            count = n;
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 != root2) {
                parents[root1] = root2;
                count--;
            }
        }

        public int find(int node) {
            while (parents[node] != node) {
                node = parents[node];
                parents[node] = parents[parents[node]];
            }

            return node;
        }

        public boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }
}
