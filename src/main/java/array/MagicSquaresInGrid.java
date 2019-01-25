package array;

public class MagicSquaresInGrid {

    public boolean isMagicSquare(int[][] grid, int x, int y) {
        int[] counts = new int[10];

        int lineCount = grid[x][y] + grid[x][y + 1] + grid[x][y + 2];
        for (int i = x; i < x + 3; i++) {
            int cur = 0;
            for (int j = y; j < y + 3; j++) {
                cur += grid[i][j];
                if (grid[i][j] > 9 || grid[i][j] < 0) {
                    return false;
                }
                counts[grid[i][j]] += 1;
            }
            if (cur != lineCount) {
                return false;
            }
        }

        for (int i = 1; i < counts.length; i++) {
            if (counts[i] != 1) {
                return false;
            }
        }

        int rowCount = grid[x][y] + grid[x + 1][y] + grid[x + 2][y];
        for (int j = y; j < y + 3; j++) {
            int cur = 0;
            for (int i = x; i < x + 3; i++) {
                cur += grid[i][j];
            }
            if (rowCount != cur) {
                return false;
            }
        }
        return grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2] == grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y];
    }

    public int numMagicSquaresInside(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new MagicSquaresInGrid().numMagicSquaresInside(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
    }
}
