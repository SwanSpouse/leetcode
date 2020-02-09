package array;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] ret = new int[r][c];
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                ret[x][y++] = nums[i][j];
                if (y == c) {
                    y = 0;
                    x += 1;
                }
            }
        }
        return ret;
    }
}
