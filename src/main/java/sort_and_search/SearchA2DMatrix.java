package sort_and_search;

class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 ){
            return false;
        }
        int len = matrix.length * matrix[0].length;
        int left = 0;
        int right =len - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            int x = mid / matrix[0].length;
            int y = mid % matrix[0].length;

            if(matrix[x][y] == target) {
                return true;
            } else if( matrix[x][y] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}