package sort_and_search;

public class CountNegativeNumbersInASortedMatrix {

    public int countNegatives(int[] grid) {
        if (grid[grid.length - 1] > 0) {
            return grid.length;
        } else if (grid[0] < 0) {
            return -1;
        }
        int left = 0, right = grid.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (grid[mid] >= 0) {
                left = mid + 1;
            } else if (grid[mid] < 0) {
                right = mid - 1;
            }
        }
        return left;
    }

    public int countNegatives(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int cur = countNegatives(grid[i]);
            if (cur <= 0) {
                count += grid[i].length;
            } else if (cur >= grid[i].length) {
                count += 0;
            } else {
                count += grid[i].length - cur;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(new CountNegativeNumbersInASortedMatrix().countNegatives(new int[]{1, 1, -1, -2}));
//        System.out.println(new CountNegativeNumbersInASortedMatrix().countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
        System.out.println(new CountNegativeNumbersInASortedMatrix().countNegatives(new int[][]{{3, 2}, {1, 0}}));
    }
}
