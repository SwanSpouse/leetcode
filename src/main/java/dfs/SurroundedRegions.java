package dfs;

/*
广搜
 */
public class SurroundedRegions {

	public void dfs(char [][] board, int x, int y) {
		if(x >= board.length || y >= board[0].length || x < 0 || y < 0 || board[x][y] != 'O') {
			return ;
		}
		board[x][y] = 'S';
		dfs(board, x -1, y);
		dfs(board, x +1 ,y);
		dfs(board, x,  y-1);
		dfs(board, x , y+1);
	}

	public void solve(char[][] board) {
		if(board.length <= 1) {
			return ;
		}
        int line = board.length;
        int row  = board[0].length;
        // up
        for(int j=0; j < row; j ++ ) {
		    if(board[0][j] == 'X' || board[0][j] == 'S') {
		        continue ;
            }
            dfs(board, 0, j);
        }
        // right
        for(int i =0; i < line; i ++ ) {
            if(board[i][row-1] == 'X'  || board[i][row-1] == 'S' ) {
                continue;
            }
            dfs(board, i, row-1);
        }
        // down
        for(int j=0; j < row; j ++ ) {
		    if (board[line-1][j] == 'X' || board[line-1][j] == 'S') {
		        continue;
            }
            dfs(board, line-1, j);
        }
        // left
        for(int i=0; i < line; i ++ ) {
		    if(board[i][0] == 'X' || board[i][0] == 'S') {
		        continue;
            }
            dfs(board, i, 0);
        }

		// change O to X and  S to O
		for(int i=0; i < line; i ++ ) {
			for(int j =0; j < row; j ++ ) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'S') {
					board[i][j] = 'O';
				}
			}
		}
    }
}
