class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int rowNum = board.length;
        int colNum = board[0].length;
        for (int i = 0; i < rowNum; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][colNum - 1] == 'O') dfs(board, i, colNum - 1);
        }
        
        for (int j = 0; j < colNum; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rowNum - 1][j] == 'O') dfs(board, rowNum - 1, j);
        }
        
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    
    //dfs will turn 0 to *
    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') return;
        board[x][y] = '*';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}
