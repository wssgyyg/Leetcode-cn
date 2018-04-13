import org.omg.CORBA.CODESET_INCOMPATIBLE;

public class No79 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] isVisited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = backtrack(board, word, isVisited, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, String word, boolean[][] isVisited, int nowRow, int nowColumn,
            int indexString) {
        if (indexString == word.length()) {
            return true;
        }

        int rows = board.length;
        int columns = board[0].length;

        if (nowRow < 0
                || nowRow >= rows
                || nowColumn < 0
                || nowColumn >= columns
                || word.charAt(indexString) != board[nowRow][nowColumn]) {
            return false;
        }

        isVisited[nowRow][nowColumn] = true;
        boolean result = backtrack(board, word, isVisited, nowRow + 1, nowColumn, indexString + 1)
                || backtrack(board, word, isVisited, nowRow - 1, nowColumn, indexString + 1)
                || backtrack(board, word, isVisited, nowRow, nowColumn + 1, indexString + 1)
                || backtrack(board, word, isVisited, nowRow, nowColumn - 1, indexString + 1);
        isVisited[nowRow][nowColumn] = false;

        return result;
    }
}
