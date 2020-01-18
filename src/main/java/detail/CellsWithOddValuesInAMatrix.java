package detail;

class CellsWithOddValuesInAMatrix{
    public int oddCells(int n, int m, int[][] indices) {
        int[][] ret = new int[n][m];
        for(int i=0; i < indices.length; i ++ ) {
            int ri = indices[i][0], ci = indices[i][1];
            for(int col = 0; col < m;  col ++) {
                ret[ri][col] += 1;
            }
            for(int row = 0; row < n; row ++) {
                ret[row][ci] += 1;
            }
        }
        int sum = 0 ;
        for(int i = 0; i < n; i ++) {
            for(int j =0; j <m; j ++) {
                sum += ret[i][j] % 2 == 1 ? 1 : 0 ;
            }
        }
        return sum;
    }
}