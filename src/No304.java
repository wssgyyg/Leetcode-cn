public class No304 {

}

class NumMatrix {
    int[][] nums;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        nums = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1] - nums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int iMax = Math.max(row1, row2);
        int jMax = Math.max(col1, col2);
        int iMin = Math.min(row1, row2);
        int jMin = Math.min(col1, col2);

        return nums[iMax + 1][jMax + 1] - nums[iMin][jMax + 1] - nums[iMax + 1][jMin] + nums[iMin][jMin];
    }
}
