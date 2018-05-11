public class No463 {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, overlap = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (i < grid.length - 1 && grid[i+1][j] == 1) overlap++;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) overlap++;
                }
            }
        }
        return islands * 4 - 2 * overlap;
    }

}
