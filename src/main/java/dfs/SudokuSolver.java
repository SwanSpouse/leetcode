package dfs;

class SudokuSolver {
	public static boolean check(int[] pos) {
        for(int i=0; i < pos.length; i ++ ) {
            if (pos[i] != 0 && pos[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        int length = board.length;
        // check row 
        for(int i=0; i < length; i ++ ) {
            int[] pos = new int[9];
            for(int j =0; j < length; j ++ ) {
                if(board[i][j] == '.') {
                    continue ;
                } else {
                    pos[board[i][j] - '1'] += 1;
                }
            }
            if (!check(pos)) {
                return false;
            }
        }

        // check line
        for(int j =0; j < length; j ++ ) {
            int[] pos = new int[9];
            for(int i =0; i < length; i ++ ) {
                if(board[i][j] == '.') {
                    continue ;
                } else {
                    pos[board[i][j] - '1'] += 1;
                }
            }
            if (!check(pos)) {
                return false;
            }
        }

        // check square
        for(int i=0; i < length; i += 3) {
            for(int j=0; j <length; j += 3) {
                int[] pos = new int[9];
                for(int row = i; row < i +3; row ++ ) {
                    for(int line = j; line < j +3 ; line ++) {
                        if(board[row][line] == '.') {
                            continue ;
                        } else {
                            pos[board[row][line] - '1'] += 1;
                        }
                    }
                }
                if(!check(pos)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(char[][] borad, int i, int j) {
    	
    }

	public static void solveSudoku(char[][] board) {

    }
}








