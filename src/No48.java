public class No48 {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        flipYAxisCenter(matrix);
    }

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void flipYAxisCenter(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int middleColumn = matrix[0].length / 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = middleColumn; j < columns; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][columns - j - 1];
                matrix[i][columns - j - 1] = temp;
            }
        }
    }
}
