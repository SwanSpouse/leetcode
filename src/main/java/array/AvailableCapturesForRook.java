package array;

public class AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {
        int rookI = 0, rookJ = 0;
        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    rookI = i;
                    rookJ = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        int count = 0;
        // 向右
        for (int i = rookI + 1; i < board.length; i++) {
            if (board[i][rookJ] == '.') {
                continue;
            }
            if (board[i][rookJ] >= 'a' && board[i][rookJ] <= 'z') {
                count += 1;
                break;
            }
            if (board[i][rookJ] >= 'A' && board[i][rookJ] <= 'Z') {
                break;
            }
        }
        // 向左
        for (int i = rookI - 1; i >= 0; i--) {
            if (board[i][rookJ] == '.') {
                continue;
            }
            if (board[i][rookJ] >= 'a' && board[i][rookJ] <= 'z') {
                count += 1;
                break;
            }
            if (board[i][rookJ] >= 'A' && board[i][rookJ] <= 'Z') {
                break;
            }
        }
        // 向上
        for (int j = rookJ - 1; j >= 0; j--) {
            if (board[rookI][j] == '.') {
                continue;
            }
            if (board[rookI][j] >= 'a' && board[rookI][j] <= 'z') {
                count += 1;
                break;
            }
            if (board[rookI][j] >= 'A' && board[rookI][j] <= 'Z') {
                break;
            }
        }
        // 向下
        for (int j = rookJ + 1; j < board.length; j++) {
            if (board[rookI][j] == '.') {
                continue;
            }
            if (board[rookI][j] >= 'a' && board[rookI][j] <= 'z') {
                count += 1;
                break;
            }
            if (board[rookI][j] >= 'A' && board[rookI][j] <= 'Z') {
                break;
            }
        }
        return count;
    }
}
