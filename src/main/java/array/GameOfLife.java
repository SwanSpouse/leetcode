package array;

import utils.Print;

public class GameOfLife {

    public static final int dead = 0;
    public static final int live = 1;
    public static final int toBorn = 2;
    public static final int toDie  = 3;

    public void setCurrentStatus(int[][] board, int x, int y) {
        int liveCount = 0;
        for(int i = x -1; i <= x + 1; i ++ ) {
            for(int j = y -1 ; j <= y+1; j ++) {
                if( i >= board.length || i < 0) {
                    continue ;
                }
                if(j >= board[i].length || j < 0) {
                    continue;
                }
                if(i == x && j == y) {
                    continue ;
                }
                if (board[i][j] == live || board[i][j] == toDie) {
                    liveCount += 1;
                }
            }
        }
        if(liveCount < 2) {
            board[x][y] = board[x][y] == live ? toDie : dead;
        } else if(liveCount == 2) {
            // do nothing
        } else if (liveCount == 3 ) {
            board[x][y] = board[x][y] == dead ? toBorn : live;
        } else if(liveCount > 3) {
            board[x][y] = board[x][y] == live ? toDie : dead;
        }
    }

    public void gameOfLife(int[][] board) {
        for(int i=0; i < board.length; i ++) {
            for(int j =0; j < board[i].length; j ++) {
                setCurrentStatus(board, i, j);
            }
        }
        for(int i=0; i < board.length; i ++) {
            for(int j =0; j < board[i].length; j ++) {
                if(board[i][j] == toBorn) {
                    board[i][j] = live;
                } else if(board[i][j] == toDie) {
                    board[i][j] = dead;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new GameOfLife().gameOfLife(input);
        Print.print2DArr(input);
    }
}
