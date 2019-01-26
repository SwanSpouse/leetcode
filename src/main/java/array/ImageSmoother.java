package array;

import utils.Print;

public class ImageSmoother {

    public int smooth(int[][] M, int x, int y) {
        int countOnes = 0, total = 0;
        int lineMax = M.length, rowMax = M[0].length;

        int[] ret = new int[9];
        int leftUp = x - 1 >= 0 && y - 1 >= 0 ? M[x - 1][y - 1] : -1;
        int up = x - 1 >= 0 ? M[x - 1][y] : -1;
        int rightUp = x - 1 >= 0 && y + 1 < rowMax ? M[x - 1][y + 1] : -1;
        int left = y - 1 >= 0 ? M[x][y - 1] : -1;
        int center = M[x][y];
        int right = y + 1 < rowMax ? M[x][y + 1] : -1;
        int leftDown = x + 1 < lineMax && y - 1 >= 0 ? M[x + 1][y - 1] : -1;
        int down = x + 1 < lineMax ? M[x + 1][y] : -1;
        int rightDown = x + 1 < lineMax && y + 1 < rowMax ? M[x + 1][y + 1] : -1;

        ret[0] = leftUp;
        ret[1] = up;
        ret[2] = rightUp;
        ret[3] = left;
        ret[4] = center;
        ret[5] = right;
        ret[6] = leftDown;
        ret[7] = down;
        ret[8] = rightDown;

        for (int i = 0; i < ret.length; i++) {
            if (ret[i] == -1) {
                continue;
            }
            if (ret[i] > 0) {
                countOnes += ret[i];
            }
            total += 1;
        }
        return countOnes / total;
    }

    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0) {
            return M;
        }
        int[][] ret = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                ret[i][j] = smooth(M, i, j);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.print2DArr(new ImageSmoother().imageSmoother(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
    }
}
