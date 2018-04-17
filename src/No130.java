public class No130 {

    int rows;
    int cols;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        rows = board.length;
        cols = board[0].length;

        UnionFind unionFind = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                        unionFind.union(node(i, j), dummyNode);
                    } else {
                        if (i > 0 && board[i - 1][j] == 'O') unionFind.union(node(i - 1, j), node(i, j));
                        if (i < rows - 1 && board[i + 1][j] == 'O') unionFind.union(node(i + 1, j), node(i, j));
                        if (j > 0 && board[i][j - 1] == 'O') unionFind.union(node(i, j - 1), node(i, j));
                        if (j < cols - 1 && board[i][j + 1] == 'O') unionFind.union(node(i, j+ 1), node(i, j));
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (unionFind.isConnect(node(i, j), dummyNode)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int node(int i, int j) {
        return i * cols + j;
    }
}
