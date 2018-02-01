package sort_and_search;

class SearchA2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length-1;

        while(x < matrix.length && y >=0) {
            if(matrix[x][y] == target) {
                return true;
            } else if( matrix[x][y] > target ) {
                y -= 1;
            } else {
                x += 1;
            }
        }
        return false;
    }
}