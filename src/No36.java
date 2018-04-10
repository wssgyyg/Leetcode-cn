import java.util.HashSet;
import java.util.Set;

public class No36 {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Set<Character> rowSet = new HashSet<>();
        Set<Character> columnSet = new HashSet<>();
        Set<Character> cubeSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int cubeStartRow = (i / 3) * 3;
            int cubeStartColumn = (i % 3) * 3;
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columnSet.add(board[j][i])) {
                    return false;
                }
                if (board[cubeStartRow + j / 3][cubeStartColumn + j % 3] != '.' && !cubeSet
                        .add(board[cubeStartRow + j / 3][cubeStartColumn + j % 3])) {
                    return false;
                }
            }
            rowSet.clear();
            columnSet.clear();
            cubeSet.clear();
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] chars = new char[9][9];
        for (int i = 0; i < 9; i++) {
            chars[i] = new char[] {};
        }
    }
}
