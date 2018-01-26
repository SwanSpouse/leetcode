package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *  深度搜索问题 经典问题
 */
class NQueues {
    public static boolean checkPos(char[][] board, int line, int row) {
        // check line 
        for (int i = 0; i < board.length; i++) {
            if (i != line && board[i][row] == 'Q') {
                return false;
            }
        }
        // check row
        for (int j = 0; j < board.length; j++) {
            if (j != row && board[line][j] == 'Q') {
                return false;
            }
        }
        // left up
        for (int i = line - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // left down
        for (int i = line - 1, j = row + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right up
        for (int i = line + 1, j = row - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right down
        for (int i = line + 1, j = row + 1; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void dfs(List<List<String>> ret, char[][] board, int line) {
        if (line >= board.length) {
            ArrayList<String> curRet = new ArrayList<String>();
            for (int i = 0; i < board.length; i++) {
                String str = "";
                for (int j = 0; j < board.length; j++) {
                    str += board[i][j];
                }
                curRet.add(str);
            }
            ret.add(curRet);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (checkPos(board, line, j)) {
                board[line][j] = 'Q';
                dfs(ret, board, line + 1);
                board[line][j] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(ret, board, 0);
        return ret;
    }

    public static void main(String[] args) {
        List<List<String>> ret = solveNQueens(4);
        System.out.println();
        print(ret);
    }

    public static void print(List<List<String>> bord) {
        for (List<String> list : bord) {
            for (String item : list) {
                System.out.println(item);
            }
            System.out.println("===========");
        }
    }
}
