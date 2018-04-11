import java.util.ArrayList;
import java.util.List;

public class No54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0) return result;
        int columns = matrix[0].length;
        int top = 0, down = rows - 1, left = 0, right = columns - 1;

        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= down; i++) {
                result.add(matrix[i][right]);
            }

            if (top < down) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
            }

            if (left < right) {
                for (int i = down - 1; i >= top + 1; i--) {
                    result.add(matrix[i][left]);
                }
            }
            ++top;
            --down;
            ++left;
            --right;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[] { 1, 2, 3 };
        matrix[1] = new int[] { 4, 5, 6 };
        matrix[2] = new int[] { 7, 8, 9 };
        System.out.println(new No54().spiralOrder(matrix));
    }
}
