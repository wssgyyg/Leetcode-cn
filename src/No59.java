public class No59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int num = 1;
        int left = 0, right = n - 1, top = 0, down = n - 1;
        while (left <= right && top <= down) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }

            for (int i = top + 1; i <= down; i++) {
                matrix[i][right] = num++;
            }

            if (top < down) {
                for (int i = right - 1; i >= left; i--) {
                    matrix[down][i] = num++;
                }
            }

            if (left < right) {
                for (int i = down - 1; i <= top + 1; i--) {
                    matrix[i][left] = num++;
                }
            }

            left++;
            right--;
            top++;
            down--;
        }

        return matrix;
    }
}
