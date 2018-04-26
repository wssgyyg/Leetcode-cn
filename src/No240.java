public class No240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = rows - 1, j = 0;
        while (i >= 0 && j < cols) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
