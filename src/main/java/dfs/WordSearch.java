package dfs;

/**
 * dfs思想。 其中用到了记事本。
 */ 
public class WordSearch {

	public static boolean dfs(char[][] board, int[][] visited, String word, int cur, int x, int y) {
		if(cur >= word.length()) {
			return true;
		}
		if(x >= board.length || x < 0 || y >= board[x].length || y < 0) {
			return false;
		}
		if (board[x][y] != word.charAt(cur)) {
			return false;
		}
		if (visited[x][y] == 1) {
			return false;
		}
		visited[x][y] = 1;
		//上左下右
		boolean ret =  dfs(board, visited, word, cur+1, x-1, y) || 
					   dfs(board, visited, word, cur+1, x, y-1) || 
					   dfs(board, visited, word, cur+1, x+1, y) || 
					   dfs(board, visited, word, cur+1, x, y +1);
		if (ret) {
			return ret;
		}
		visited[x][y] = 0;
		return false;
	}

    public static boolean exist(char[][] board, String word) {
    	if(board.length == 0) {
    		return false;
    	}
    	int[][] visited = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i ++ ) {
        	for(int j=0; j < board[i].length; j ++) {
		     	if (dfs(board, visited, word, 0, i, j)){
		     		return true;
		     	}
        	}
        }
        return false;
    }
}