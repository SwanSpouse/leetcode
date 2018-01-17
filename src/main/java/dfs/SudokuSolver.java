package dfs;

/**
 *     很明显的这是一道dfs的题。但是我还没有找到函数的出口。
 * 函数的结束条件是啥呢。和自己做过的树相关的题联系联系。
 */
class SudokuSolver {

    public static boolean dfs(char[][] board, int i, int j) {
        if( i >= board.length || j >= board.length ) {
            return isValidSudoku(board);
        }
        if( board[i][j] != '.') {
            i = j + 1 < board.length ? i : i + 1;
            j = j + 1 < board.length ? j + 1 : 0;
            return dfs(board, i ,j);
        }

        for(char ch = '1'; ch <= '9'; ch += 1 ) {
            board[i][j] = ch;
            if(isValidSudoku(board)) {
                i = j + 1 < board.length ? i : i + 1;
                j = j + 1 < board.length ? j + 1 : 0;
                if(dfs(board, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }   

    public static void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

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
}
