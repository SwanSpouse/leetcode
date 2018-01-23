package array;

/**
 *  这题做过一遍脑子里就一直有印象。先沿着做对角线折叠（交换横纵坐标）；然后沿纵轴对着。也是交换坐标
 */ 
class RotateImage {
    public static void rotate(int[][] matrix) {
        // 沿对角线对折，交换横纵坐标
        for(int i =0; i < matrix.length; i ++ ) {
            for(int j = i + 1; j < matrix.length; j ++ ) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 沿中轴线翻转
        for(int i =0; i < matrix.length; i ++ ) {
            for(int j = 0; j < matrix.length / 2; j ++ ) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length -1 -j];
                matrix[i][matrix.length -1 -j] = temp;
            }
        }
    }
}