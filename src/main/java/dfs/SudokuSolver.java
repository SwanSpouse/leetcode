package dfs;

import utils.Print;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *      很明显的这是一道dfs的题。但是我还没有找到函数的出口。
 *      函数的结束条件是啥呢。和自己做过的树相关的题联系联系。
 *
 *      设置dfs设置一个返回值，如果是true表示已经找到结果。不必要再进行操作了。
 */
class SudokuSolver {

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> ret = new HashSet<Character>();
            for (int j = 0; j < board[i].length; j++) {
                if ('1' <= board[i][j] && board[i][j] <= '9') {
                    ret.add(board[i][j]);
                }
            }
            if (ret.size() != 9) {
                return false;
            }
        }

        for (int j = 0; j < board.length; j++) {
            HashSet<Character> ret = new HashSet<Character>();
            for (int i = 0; i < board[j].length; i++) {
                if ('1' <= board[i][j] && board[i][j] <= '9') {
                    ret.add(board[i][j]);
                }
            }
            if (ret.size() != 9) {
                return false;
            }
        }

        // check square
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                HashSet<Character> ret = new HashSet<Character>();
                for (int row = i; row < i + 3; row++) {
                    for (int line = j; line < j + 3; line++) {
                        if ('1' <= board[row][line] && board[row][line] <= '9') {
                            ret.add(board[row][line]);
                        }
                    }
                }
                if (ret.size() != 9) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Character> generateBackUpItems(char[][] board, int i, int j) {
        int[] charCount = new int[9];

        for (int line = 0; line < board.length; line++) {
            if (board[line][j] == '.') {
                continue;
            }
            charCount[board[line][j] - '1'] += 1;
        }

        for (int row = 0; row < board.length; row++) {
            if (board[i][row] == '.') {
                continue;
            }
            charCount[board[i][row] - '1'] += 1;
        }

        for (int line = i / 3 * 3; line < i / 3 * 3 + 3; line++) {
            for (int row = j / 3 * 3; row < j / 3 * 3 + 3; row++) {
                if (board[line][row] == '.') {
                    continue;
                }
                charCount[board[line][row] - '1'] += 1;
            }
        }
        List<Character> ret = new ArrayList<Character>();
        for (int index = 0; index < charCount.length; index++) {
            if (charCount[index] == 0) {
                ret.add((char) (index + '1'));
            }
        }
        return ret;
    }


    public static boolean dfs(char[][] board, int i, int j) {
        i = j + 1 < board.length ? i : i + 1;
        j = j + 1 < board.length ? j + 1 : 0;
        if (i >= board.length || j >= board.length) {
            return isValidSudoku(board);
        }
        if (board[i][j] != '.') {
            return dfs(board, i, j);
        }

        List<Character> backUpItems = generateBackUpItems(board, i, j);
        for (char ch : backUpItems) {
            board[i][j] = ch;
            if (dfs(board, i, j)) {
                return true;
            }
        }
        board[i][j] = '.';
        return false;
    }

    public static void solveSudoku(char[][] board) {
        dfs(board, 0, -1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
//                {'5', '1', '9', '7', '4', '8', '6', '3', '2'},
//                {'7', '8', '3', '6', '5', '2', '4', '1', '9'},
//                {'4', '2', '6', '1', '3', '9', '8', '7', '5'},
//                {'3', '5', '7', '9', '8', '6', '2', '4', '1'},
//                {'2', '6', '4', '3', '1', '7', '5', '9', '8'},
//                {'1', '9', '8', '5', '2', '4', '3', '6', '7'},
//                {'9', '7', '5', '8', '6', '3', '1', '2', '4'},
//                {'8', '3', '2', '4', '9', '1', '7', '5', '6'},
//                {'6', '4', '1', '2', '7', '5', '9', '8', '3'}
        };

//        List<Character> ret = generateBackUpItems(board, 3, 2);
//        Print.printList(ret);
        solveSudoku(board);
        System.out.println();
        System.out.println();
        System.out.println();
        Print.print2DArr(board);
    }
}
